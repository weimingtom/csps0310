package com.edot.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 注册返回
 * Created by tony on 16/2/14.
 */
public class RegisterResponse {

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
