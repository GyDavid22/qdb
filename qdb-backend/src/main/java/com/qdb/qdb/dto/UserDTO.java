package com.qdb.qdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qdb.qdb.entity.User;

@JsonSerialize
public class UserDTO {
    private long id;
    private String userName;
    private User.Rank rank;

    public UserDTO(long id, String userName, User.Rank rank) {
        this.id = id;
        this.userName = userName;
        this.rank = rank;
    }

    public static UserDTO toDTO(User u) {
        return new UserDTO(u.getId(), u.getUserName(), u.getRank());
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

    public User.Rank getRank() {
        return rank;
    }

    public void setRank(User.Rank rank) {
        this.rank = rank;
    }
}
