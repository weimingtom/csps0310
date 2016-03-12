package com.edot.web.request;

import org.hibernate.validator.constraints.Length;

/**
 * 注册请求
 * Created by tony on 16/2/14.
 */
public class RegisterRequest {

    @Length(min = 6, max = 12)
    private String username;
    @Length(min = 6, max = 12)
    private String password;
    @Length(min = 11, max = 11)
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
