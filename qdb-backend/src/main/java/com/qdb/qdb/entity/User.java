package com.qdb.qdb.entity;

import jakarta.annotation.Nullable;
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
    private Long id;
    private String userName;
    @Enumerated(EnumType.STRING)
    private Rank rank;
    @Nullable
    @OneToOne
    private ProfilePicture profilePicture;
    private char[] hashedPassword;
    private char[] salt;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Session> sessions;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Collection<Question> questions;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Question> favorites;

    public User() {
    }

    public User(Long id, String userName, Rank rank, @Nullable ProfilePicture profilePicture, char[] hashedPassword, char[] salt, Collection<Session> sessions, Collection<Question> questions, Collection<Question> favorites) {
        this.id = id;
        this.userName = userName;
        this.rank = rank;
        this.profilePicture = profilePicture;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.sessions = sessions;
        this.questions = questions;
        this.favorites = favorites;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Nullable
    public ProfilePicture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(@Nullable ProfilePicture profilePicture) {
        this.profilePicture = profilePicture;
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

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    public Collection<Question> getFavorites() {
        return favorites;
    }

    public void setFavorites(Collection<Question> favorites) {
        this.favorites = favorites;
    }

    public enum Rank {
        SUPERUSER, ADMIN, NORMAL, RESTRICTED
    }
}
