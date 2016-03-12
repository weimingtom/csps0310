package com.edot.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 用户
 * Created by tony on 16/1/20.
 */
@Entity(name = "biz_user")
public class BizUserModel extends BaseModel {

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "type")
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
