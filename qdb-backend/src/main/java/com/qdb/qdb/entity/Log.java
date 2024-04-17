package com.qdb.qdb.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

/**
 * Class to represent log entries. Not directly linked to entities, so e.g. after an user gets deleted, the log entry will be kept
 */
@Entity
@JsonSerialize
public class Log {
    @GeneratedValue
    @Id
    private Long id;
    private LocalDateTime time;
    private long userId;
    private String userName;
    private String action;
    private String roleAtTheMoment;
    private boolean wasPermissionGranted;

    public Log() {
    }

    public Log(Long id, LocalDateTime time, long userId, String userName, String action, String roleAtTheMoment, boolean wasPermissionGranted) {
        this.id = id;
        this.time = time;
        this.userId = userId;
        this.userName = userName;
        this.action = action;
        this.roleAtTheMoment = roleAtTheMoment;
        this.wasPermissionGranted = wasPermissionGranted;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRoleAtTheMoment() {
        return roleAtTheMoment;
    }

    public void setRoleAtTheMoment(String roleAtTheMoment) {
        this.roleAtTheMoment = roleAtTheMoment;
    }

    public boolean isWasPermissionGranted() {
        return wasPermissionGranted;
    }

    public void setWasPermissionGranted(boolean wasPermissionGranted) {
        this.wasPermissionGranted = wasPermissionGranted;
    }
}
