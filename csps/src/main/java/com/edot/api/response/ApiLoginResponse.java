package com.edot.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * API登录返回
 * Created by tony on 16/2/3.
 */
public class ApiLoginResponse {

    private String token;
    @JsonProperty("user_id")
    private Long userId;
    private String username;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
