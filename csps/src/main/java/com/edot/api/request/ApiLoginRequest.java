package com.edot.api.request;

/**
 * API登录请求
 * Created by tony on 16/2/3.
 */
public class ApiLoginRequest {

    private String username;
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
