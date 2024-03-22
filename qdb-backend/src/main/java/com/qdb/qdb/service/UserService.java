package com.qdb.qdb.service;

import com.qdb.qdb.entity.Permission;
import com.qdb.qdb.entity.ProfilePicture;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.exception.UnsupportedFileFormatException;
import com.qdb.qdb.exception.UserNotFoundException;
import com.qdb.qdb.repository.ProfilePictureRepository;
import com.qdb.qdb.repository.UserRepository;
import jakarta.annotation.Nullable;
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
    @Autowired
    private final PermissionService pService;

    public UserService(UserRepository repo, SessionService sService, ProfilePictureRepository pRepo, PermissionService pService) {
        this.repo = repo;
        this.sService = sService;
        this.pRepo = pRepo;
        this.pService = pService;
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
        pService.checkPermission(u, Permission.Action.LOGIN, false);
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
        char[] salt = generateSalt();
        User u = new User(null, username, User.Rank.RESTRICTED, null, hashPassword(password, salt), salt, null, null);
        repo.saveAndFlush(u);
        return u;
    }

    /**
     * Get User by username
     *
     * @param username
     * @return User object with the given username, null if doesn't exist
     */
    public User getByUserName(String username, @Nullable User u) throws NoRightException {
        if (u != null) {
            pService.checkPermission(u, Permission.Action.GET_USER_METADATA, false);
        }
        Optional<User> res = repo.findByUserName(username);
        return res.orElse(null);
    }

    public List<User> getAllUsers(User u) throws NoRightException {
        pService.checkPermission(u, Permission.Action.GET_USER_METADATA, false);
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
     * @param u
     * @param toSet
     * @param newPassword
     * @throws NoRightException
     */
    public void setPasswordByAdmin(User u, User toSet, char[] newPassword) throws NoRightException {
        if (toSet.getRank() == User.Rank.SUPERUSER) {
            pService.checkPermission(u, Permission.Action.EDIT_SUPERUSER, false);
        } else if (toSet.getRank() == User.Rank.ADMIN) {
            pService.checkPermission(u, Permission.Action.EDIT_ADMIN, false);
        } else {
            pService.checkPermission(u, Permission.Action.EDIT_NORMAL_RESTRICTED, false);
        }
        toSet.setSalt(generateSalt());
        toSet.setHashedPassword(hashPassword(newPassword, toSet.getSalt()));
        sService.deleteAllSessionOfUser(toSet);
        repo.flush();
    }

    /**
     * Method to change a user's rank
     *
     * @param u       An admin user who sets the rank
     * @param toSet   The User whose rank is set
     * @param newRank New rank of user
     */
    public void setRank(User u, User toSet, User.Rank newRank) throws NoRightException {
        if (toSet.getRank() == User.Rank.SUPERUSER || newRank == User.Rank.SUPERUSER) {
            pService.checkPermission(u, Permission.Action.EDIT_SUPERUSER, false);
        }
        if (newRank == User.Rank.ADMIN) {
            pService.checkPermission(u, Permission.Action.EDIT_ADMIN, false);
        } else {
            pService.checkPermission(u, Permission.Action.EDIT_NORMAL_RESTRICTED, false);
        }
        toSet.setRank(newRank);
        repo.flush();
    }

    public boolean deleteUser(User u, @Nullable User withPerm) throws NoRightException {
        if (withPerm != null) {
            if (u.getRank() == User.Rank.SUPERUSER) {
                pService.checkPermission(withPerm, Permission.Action.EDIT_SUPERUSER, false);
            } else if (u.getRank() == User.Rank.ADMIN) {
                pService.checkPermission(withPerm, Permission.Action.EDIT_ADMIN, false);
            } else {
                pService.checkPermission(withPerm, Permission.Action.EDIT_NORMAL_RESTRICTED, false);
            }
        }
        if (u.getRank() == User.Rank.SUPERUSER && repo.countByRank(User.Rank.SUPERUSER) == 1) {
            return false;
        }
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
                return new ProfilePicture(null, Files.readAllBytes(Path.of("assets/default.png")), null, ProfilePicture.Format.PNG);
            } catch (IOException e) {
                return null;
            }
        }
        return u.get().getProfilePicture();
    }

    /**
     * If admin is null, the profile picture will be set either way, if not, admin needs to be an admin.
     *
     * @param image
     * @param contentType
     * @param username
     * @throws UserNotFoundException
     * @throws UnsupportedFileFormatException
     * @throws NoRightException
     */
    public void setProfilePicture(byte[] image, String contentType, String username) throws UserNotFoundException, UnsupportedFileFormatException, NoRightException {
        Optional<User> res = repo.findByUserName(username);
        if (res.isEmpty()) {
            throw new UserNotFoundException();
        }
        User u = res.get();
        pService.checkPermission(u, Permission.Action.SET_PROFILE_PICTURE_OWN, false);
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
        ProfilePicture pfp = new ProfilePicture(null, image, null, contentType.equalsIgnoreCase(MediaType.IMAGE_JPEG_VALUE) ? ProfilePicture.Format.JPG : ProfilePicture.Format.PNG);
        u.setProfilePicture(pfp);
        pRepo.saveAndFlush(pfp);
        repo.flush();
    }

    /**
     * If admin is null, the profile picture will be deleted either way, if not, admin needs to be an admin.
     *
     * @param username
     * @throws UserNotFoundException
     * @throws NoRightException
     */
    public void deleteProfilePicture(String username) throws UserNotFoundException, NoRightException {
        Optional<User> res = repo.findByUserName(username);
        if (res.isEmpty()) {
            throw new UserNotFoundException();
        }
        User u = res.get();
        pService.checkPermission(u, Permission.Action.RESET_PROFILE_PICTURE_OWN, false);
        if (u.getProfilePicture() != null) {
            ProfilePicture pic = u.getProfilePicture();
            pic.setOwner(null);
            u.setProfilePicture(null);
            pRepo.delete(pic);
            pRepo.flush();
            repo.flush();
        }
    }
}
