package com.edot.web.request;

import org.hibernate.validator.constraints.Length;

/**
 * 登录请求
 * Created by tony on 16/2/3.
 */
public class LoginRequest {

    @Length(min = 6, max = 12)
    private String username;
    @Length(min = 6, max = 12)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
