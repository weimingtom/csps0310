package com.edot.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 登录返回
 * Created by tony on 16/2/3.
 */
public class LoginResponse {

    @JsonProperty("user_id")
    private Long userId;
    private String token;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
