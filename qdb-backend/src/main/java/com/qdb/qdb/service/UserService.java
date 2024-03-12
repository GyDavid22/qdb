package com.qdb.qdb.service;

import com.qdb.qdb.entity.ProfilePicture;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.exception.UnsupportedFileFormatException;
import com.qdb.qdb.exception.UserNotFoundException;
import com.qdb.qdb.repository.ProfilePictureRepository;
import com.qdb.qdb.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@Service
public class UserService {
    private static final Set<String> RESERVED_KEYWORDS = new HashSet<>() {
        {
            this.add("all");
            this.add("null");
            this.add("picture");
            this.add("password");
        }
    };
    @Autowired
    private final UserRepository repo;
    @Autowired
    private final SessionService sService;
    @Autowired
    private final ProfilePictureRepository pRepo;

    public UserService(UserRepository repo, SessionService sService, ProfilePictureRepository pRepo) {
        this.repo = repo;
        this.sService = sService;
        this.pRepo = pRepo;
    }

    /**
     * Authenticate user with username and password
     *
     * @param userName
     * @param password
     * @return With the user object if succeeded, false otherwise
     */
    public User authenticate(String userName, char[] password) throws NoRightException {
        Optional<User> result = repo.findByUserName(userName);
        if (result.isEmpty()) {
            return null;
        }
        User u = result.get();
        if (u.getRank().equals(User.Rank.PENDING)) {
            throw new NoRightException();
        }
        if (Arrays.equals(u.getHashedPassword(), hashPassword(password, u.getSalt()))) {
            return u;
        }
        return null;
    }

    private char[] hashPassword(char[] password, char[] salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            for (char c : password) {
                digest.update((byte) c);
            }
            for (char c : salt) {
                digest.update((byte) c);
            }
            byte[] hash = digest.digest();
            return Base64.getEncoder().encodeToString(hash).toCharArray();
        } catch (NoSuchAlgorithmException ignored) {
        }
        return new char[]{' '};
    }

    /**
     * Creates a new User, DOESN'T SAVE IT INTO THE DATABASE
     *
     * @param username
     * @param password
     * @return The newly created user, null if username taken
     */
    public User createUser(String username, char[] password) {
        if (UserService.RESERVED_KEYWORDS.contains(username.toLowerCase()) || repo.findByUserName(username).isPresent()) {
            return null;
        }
        User u = new User();
        u.setUserName(username);
        u.setSalt(generateSalt());
        u.setHashedPassword(hashPassword(password, u.getSalt()));
        u.setRank(User.Rank.PENDING);
        u.setProfilePicture(null);
        repo.saveAndFlush(u);
        return u;
    }

    /**
     * Get User by username
     *
     * @param username
     * @return User object with the given username, null if doesn't exist
     */
    public User getByUserName(String username, User admin) throws NoRightException {
        if (!checkRights(admin, User.Rank.ADMIN)) {
            throw new NoRightException();
        }
        Optional<User> res = repo.findByUserName(username);
        return res.orElse(null);
    }

    public List<User> getAllUsers(User admin) throws NoRightException {
        if (!checkRights(admin, User.Rank.ADMIN)) {
            throw new NoRightException();
        }
        return repo.findAll();
    }

    /**
     * Method to change one's password, invalidates all other sessions for security
     *
     * @param u           User whose password should be changed
     * @param newPassword New password to set
     * @return False, if the current password doesn't match (no changes happen), true otherwise
     */
    public boolean changePassword(User u, char[] oldPassword, char[] newPassword, char[] currentSessionId) {
        try {
            if (authenticate(u.getUserName(), oldPassword) == null) {
                return false;
            }
        } catch (NoRightException e) {
            return false; // shouldn't happen at this point but better to be sure
        }
        u.setSalt(generateSalt());
        u.setHashedPassword(hashPassword(newPassword, u.getSalt()));
        u.getSessions().removeIf(s -> !Arrays.equals(s.getSessionId(), currentSessionId));
        repo.flush();
        return true;
    }

    /**
     * Method to set the password of a different user, needs admin rights, invalidates all sessions for security reasons
     *
     * @param admin
     * @param u
     * @param newPassword
     * @throws NoRightException
     */
    public void setPasswordByAdmin(User admin, User u, char[] newPassword) throws NoRightException {
        if (!checkRights(admin, User.Rank.ADMIN)) {
            throw new NoRightException();
        }
        u.setSalt(generateSalt());
        u.setHashedPassword(hashPassword(newPassword, u.getSalt()));
        sService.deleteAllSessionOfUser(u);
        repo.flush();
    }

    /**
     * Method to change a user's rank
     *
     * @param admin   An admin user who sets the rank
     * @param toSet   The User whose rank is set
     * @param newRank New rank of user
     */
    public void setRank(User admin, User toSet, User.Rank newRank) throws NoRightException {
        if (!checkRights(admin, User.Rank.ADMIN)) {
            throw new NoRightException();
        }
        toSet.setRank(newRank);
        repo.flush();
    }

    @Transactional
    public boolean deleteUser(String username) {
        Optional<User> result = repo.findByUserName(username);
        if (result.isPresent()) {
            User u = result.get();
            sService.deleteAllSessionOfUser(u);
            u.getQuestions().forEach(q -> q.setOwner(null));
            if (u.getProfilePicture() != null) {
                ProfilePicture pic = u.getProfilePicture();
                pic.setOwner(null);
                u.setProfilePicture(null);
                pRepo.delete(pic);
                pRepo.flush();
                repo.flush();
            }
            repo.delete(u);
            repo.flush();
            return true;
        }
        return false;
    }

    /**
     * Deletes user by admin
     *
     * @param username Username of user to delete
     * @param admin    An admin account
     * @return true, if deletion was successful, false otherwise (not an admin account or username doesn't exist)
     */
    @Transactional
    public boolean deleteUserByAdmin(String username, User admin) {
        if (!checkRights(admin, User.Rank.ADMIN)) {
            return false;
        }
        return deleteUser(username);
    }

    private char[] generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] id = new byte[32];
        sr.nextBytes(id);
        return Base64.getEncoder().encodeToString(id).toCharArray();
    }

    public ProfilePicture getProfilePicture(String username) {
        Optional<User> u = repo.findByUserName(username);
        if (u.isEmpty()) {
            return null;
        }
        if (u.get().getProfilePicture() == null) {
            try {
                ProfilePicture pfp = new ProfilePicture();
                pfp.setContent(Files.readAllBytes(Path.of("assets/default.png")));
                pfp.setFormat(ProfilePicture.Format.PNG);
                return pfp;
            } catch (IOException e) {
                return null;
            }
        }
        return u.get().getProfilePicture();
    }

    public void setProfilePicture(byte[] image, String contentType, String username) throws UserNotFoundException, UnsupportedFileFormatException {
        Optional<User> res = repo.findByUserName(username);
        if (res.isEmpty()) {
            throw new UserNotFoundException();
        }
        User u = res.get();
        ProfilePicture pfp = new ProfilePicture();
        if ((contentType == null) || (!contentType.equalsIgnoreCase(MediaType.IMAGE_JPEG_VALUE) && !contentType.equalsIgnoreCase(MediaType.IMAGE_PNG_VALUE))) {
            throw new UnsupportedFileFormatException();
        }
        if (u.getProfilePicture() != null) {
            ProfilePicture pic = u.getProfilePicture();
            pic.setOwner(null);
            u.setProfilePicture(null);
            pRepo.delete(pic);
            pRepo.flush();
            repo.flush();
        }
        pfp.setFormat(contentType.equalsIgnoreCase(MediaType.IMAGE_JPEG_VALUE) ? ProfilePicture.Format.JPG : ProfilePicture.Format.PNG);
        pfp.setContent(image);
        pfp.setOwner(u);
        u.setProfilePicture(pfp);
        pRepo.saveAndFlush(pfp);
        repo.flush();
    }

    public void deleteProfilePicture(String username) throws UserNotFoundException {
        Optional<User> res = repo.findByUserName(username);
        if (res.isEmpty()) {
            throw new UserNotFoundException();
        }
        User u = res.get();
        if (u.getProfilePicture() != null) {
            ProfilePicture pic = u.getProfilePicture();
            pic.setOwner(null);
            u.setProfilePicture(null);
            pRepo.delete(pic);
            pRepo.flush();
            repo.flush();
        }
    }

    /**
     * Checks whether an user has at least the given rank
     *
     * @param u
     * @param minRequired
     * @return true if the user has at least the given rank, false if it has a lower one
     */
    public boolean checkRights(User u, User.Rank minRequired) {
        return u.getRank().compareTo(minRequired) <= 0;
    }
}
