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
    private long id;
    @ManyToOne
    private User user;
    private char[] sessionId;
    private LocalDateTime lastInteraction;

    public Session() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
