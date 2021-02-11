package com.chpok.anecs.models;

public class UserSavedAnec {
    private Long userId;
    private Long anecId;

    public UserSavedAnec() {
    }

    public UserSavedAnec(Long userId, Long anecId) {
        this.userId = userId;
        this.anecId = anecId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAnecId() {
        return anecId;
    }

    public void setAnecId(Long anecId) {
        this.anecId = anecId;
    }
}
