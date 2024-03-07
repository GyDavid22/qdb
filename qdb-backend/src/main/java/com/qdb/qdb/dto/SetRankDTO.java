package com.qdb.qdb.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qdb.qdb.entity.User;

@JsonSerialize
public class SetRankDTO {
    private User.Rank rank;

    public SetRankDTO() {
    }

    public User.Rank getRank() {
        return rank;
    }

    public void setRank(User.Rank rank) {
        this.rank = rank;
    }
}
