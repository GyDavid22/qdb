package com.qdb.qdb.entity;

import jakarta.persistence.*;

import java.util.Collection;

/**
 * Represents an user account.
 */
@Entity
@Table(name = "user_db", uniqueConstraints = @UniqueConstraint(columnNames = "userName"), indexes = @Index(columnList = "userName"))
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String userName;
    private char[] hashedPassword;
    private char[] salt;
    @OneToMany(mappedBy = "user")
    private Collection<Session> sessions;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char[] getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(char[] hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public char[] getSalt() {
        return salt;
    }

    public void setSalt(char[] salt) {
        this.salt = salt;
    }

    public Collection<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Collection<Session> sessions) {
        this.sessions = sessions;
    }
}
