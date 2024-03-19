package com.qdb.qdb.entity;

import jakarta.persistence.*;

/**
 * Entity to represent permission whitelist
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"rank", "action"}))
public class Permission {
    @GeneratedValue
    @Id
    private Long id;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private User.Rank rank;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Action action;

    public Permission() {
    }

    public Permission(Long id, User.Rank rank, Action action) {
        this.id = id;
        this.rank = rank;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User.Rank getRank() {
        return rank;
    }

    public void setRank(User.Rank rank) {
        this.rank = rank;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public enum Action {
        UPLOAD_IMAGE_ANY_QUESTION, UPDATE_TAGS_ANY_QUESTION, UPDATE_TAGS_OWN_QUESTION, GET_ANY_USER_METADATA, GET_ALL_USER_METADATA, SET_ANY_USER_PASSWORD, SET_ANY_USER_RANK, DELETE_ANY_USER_ACCOUNT, UPDATE_IMAGES_ANY_QUESTION, UPDATE_IMAGES_OWN_QUESTION, LOGIN, SET_PROFILE_PICTURE_OWN, SET_PROFILE_PICTURE_ANY, RESET_PROFILE_PICTURE_ANY, RESET_PROFILE_PICTURE_OWN
    }
}
