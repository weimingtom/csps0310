package com.edot.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 注册返回
 * Created by tony on 16/2/14.
 */
public class RegisterResponse {

    @JsonProperty("user_id")
    private Long id;
    private String username;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
