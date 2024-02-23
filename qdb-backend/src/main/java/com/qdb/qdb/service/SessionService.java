package com.qdb.qdb.service;

import com.qdb.qdb.entity.Session;
import com.qdb.qdb.entity.User;
import com.qdb.qdb.repository.SessionRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

@Service
public class SessionService {
    public static final String COOKIE_NAME = "sessionId";
    @Autowired
    private final SessionRepository repo;

    public SessionService(SessionRepository repo) {
        this.repo = repo;
    }

    public void removeOlderThan(int hours) {
        repo.deleteAll(repo.findAllByLastInteractionLessThan(LocalDateTime.now().minusHours(hours)));
        repo.flush();
    }

    /**
     * Returns the user for which the sessionId belongs to
     *
     * @param sessionId SessionId to look for
     * @return The user belonging to the session, null if the gives session doesn't exist
     */
    private User getUserOfSession(char[] sessionId) {
        Optional<Session> result = repo.findBySessionId(sessionId);
        if (result.isPresent()) {
            Session resSession = result.get();
            resSession.setLastInteraction(LocalDateTime.now());
            repo.saveAndFlush(resSession);
            return resSession.getUser();
        }
        return null;
    }

    /**
     * Creates a new session and saves it into the database
     *
     * @param u User to create session for
     * @return sessionId of the new session
     */
    public char[] createSession(User u) {
        Session newSession = new Session();
        newSession.setUser(u);
        newSession.setSessionId(generateSessionId());
        newSession.setLastInteraction(LocalDateTime.now());
        repo.saveAndFlush(newSession);
        return newSession.getSessionId();
    }

    private void destroySession(char[] sessionId) {
        Optional<Session> result = repo.findBySessionId(sessionId);
        if (result.isPresent()) {
            repo.delete(result.get());
            repo.flush();
        }
    }

    public void deleteAllSessionOfUser(User u) {
        repo.deleteAll(u.getSessions());
        repo.flush();
    }

    private char[] generateSessionId() {
        SecureRandom sr = new SecureRandom();
        byte[] id = new byte[64];
        sr.nextBytes(id);
        return Base64.getEncoder().encodeToString(id).toCharArray();
    }

    /**
     * Checks the validity of the cookies, invalidates cookies with invalid sessionId
     *
     * @param cookies Cookies to check
     * @return User object the cookie belongs to, null otherwise
     */
    public User checkCookieValidity(Cookie[] cookies, HttpServletResponse response) {
        if (cookies == null) {
            return null;
        }
        for (Cookie c : cookies) {
            if (c.getName().equals(COOKIE_NAME)) {
                User u = getUserOfSession(c.getValue().toCharArray());
                if (u != null) {
                    return u;
                } else {
                    invalidateCookie(c, response);
                    break;
                }
            }
        }
        return null;
    }

    /**
     * Invalidates cookies and attaches them to the response. If the cookie contains a valid sessionId, that session will also be deleted.
     *
     * @param c
     * @param response
     */
    public void invalidateCookie(Cookie c, HttpServletResponse response) {
        destroySession(c.getValue().toCharArray());
        c.setMaxAge(0);
        c.setValue("");
        response.addCookie(c);
    }
}
