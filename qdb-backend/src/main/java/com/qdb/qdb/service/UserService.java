package com.qdb.qdb.service;

import com.qdb.qdb.entity.User;
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
    public User authenticate(String userName, char[] password) {
        Optional<User> result = repo.findByUserName(userName);
        if (result.isEmpty()) {
            return null;
        }
        User u = result.get();
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
     * @return The newly created user
     */
    public User createUser(String username, char[] password) {
        User u = new User();
        u.setUserName(username);
        u.setSalt(generateSalt());
        u.setHashedPassword(hashPassword(password, u.getSalt()));
        return u;
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

    private char[] generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] id = new byte[32];
        sr.nextBytes(id);
        return Base64.getEncoder().encodeToString(id).toCharArray();
    }

    public boolean checkRights(User u, User.Rank minRequired) {
        return u.getRank().compareTo(minRequired) <= 0;
    }
}
