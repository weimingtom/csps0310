package com.edot.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * 登录报文
 * version:2
 * Created by tony on 16/2/21.
 */
public class LoginRequestV2 {
    @Length(min = 6, max = 12)
    private String username;
    @Length(min = 6, max = 12)
    private String password;
    private String type;
    @JsonProperty("device_token")
    private String deviceToken;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
