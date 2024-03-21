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
        CREATE_QUESTION,
        UPDATE_QUESTION_OWN,
        UPDATE_QUESTION_OWNER_ADMIN,
        UPDATE_QUESTION_OWNER_SUPERUSER,
        GET_USER_METADATA,
        SET_ANY_USER_PASSWORD,
        SET_ANY_USER_RANK,
        SET_RANK_NORMAL_RESTRICTED,
        DELETE_ANY_USER_ACCOUNT,
        DELETE_USER_ACCOUNT_NORMAL_RESTRICTED,
        LOGIN,
        SET_PROFILE_PICTURE_OWN,
        RESET_PROFILE_PICTURE_OWN,
        UPLOAD_IMAGE
    }
}
