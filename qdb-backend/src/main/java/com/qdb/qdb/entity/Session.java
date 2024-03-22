package com.qdb.qdb.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Represents a Session of a User. It shouldn't exist on its own without a User.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "sessionId"), indexes = @Index(columnList = "sessionId"))
public class Session {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    private char[] sessionId;
    private LocalDateTime lastInteraction;

    public Session() {
    }

    public Session(Long id, User user, char[] sessionId, LocalDateTime lastInteraction) {
        this.id = id;
        this.user = user;
        this.sessionId = sessionId;
        this.lastInteraction = lastInteraction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public char[] getSessionId() {
        return sessionId;
    }

    public void setSessionId(char[] sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDateTime getLastInteraction() {
        return lastInteraction;
    }

    public void setLastInteraction(LocalDateTime lastInteraction) {
        this.lastInteraction = lastInteraction;
    }
}
