package com.qdb.qdb.service;

import com.qdb.qdb.entity.User;
import com.qdb.qdb.exception.NoRightException;
import com.qdb.qdb.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository repo;
    @Autowired
    private final SessionService sService;

    public UserService(UserRepository repo, SessionService sService) {
        this.repo = repo;
        this.sService = sService;
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
        if (repo.findByUserName(username).isPresent()) {
            return null;
        }
        User u = new User();
        u.setUserName(username);
        u.setSalt(generateSalt());
        u.setHashedPassword(hashPassword(password, u.getSalt()));
        u.setRank(User.Rank.PENDING);
        repo.saveAndFlush(u);
        return u;
    }

    /**
     * Method to change one's password
     *
     * @param u           User whose password should be changed
     * @param newPassword New password to set
     * @return False, if the current password doesn't match (no changes happen), true otherwise
     */
    public boolean changePassword(User u, char[] oldPassword, char[] newPassword) {
        try {
            if (authenticate(u.getUserName(), oldPassword) == null) {
                return false;
            }
        } catch (NoRightException e) {
            return false; // shouldn't happen at this point but better to be sure
        }
        u.setSalt(generateSalt());
        u.setHashedPassword(hashPassword(newPassword, u.getSalt()));
        repo.flush();
        return true;
    }

    /**
     * Method to change a user's rank
     *
     * @param admin   An admin user who sets the rank
     * @param toSet   The User whose rank is set
     * @param newRank New rank of user
     * @return False, if admin doesn't actually have admin rights (no changes will be made), true otherwise
     */
    public boolean setRank(User admin, User toSet, User.Rank newRank) {
        if (!checkRights(admin, User.Rank.ADMIN)) {
            return false;
        }
        toSet.setRank(newRank);
        repo.flush();
        return true;
    }

    @Transactional
    public void deleteUser(long userID) {
        Optional<User> result = repo.findById(userID);
        if (result.isPresent()) {
            User u = result.get();
            sService.deleteAllSessionOfUser(u);
            repo.delete(u);
            repo.flush();
        }
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
        Optional<User> result = repo.findByUserName(username);
        if (result.isPresent()) {
            User u = result.get();
            sService.deleteAllSessionOfUser(u);
            repo.delete(u);
            repo.flush();
            return true;
        }
        return false;
    }

    private char[] generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] id = new byte[32];
        sr.nextBytes(id);
        return Base64.getEncoder().encodeToString(id).toCharArray();
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
