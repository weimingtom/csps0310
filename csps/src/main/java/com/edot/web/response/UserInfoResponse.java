package com.edot.web.response;

/**
 * 用户信息返回报文
 * Created by tony on 16/2/19.
 */
public class UserInfoResponse {

    private String username;
    private String telephone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
