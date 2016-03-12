package com.edot.api.request;

/**
 * API注册请求
 * Created by tony on 16/2/14.
 */
public class ApiRegisterRequest {

    private String username;
    private String password;
    private String telephone;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
