package com.edot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edot.api.ApiUrls;
import com.edot.api.request.ApiLoginRequest;
import com.edot.api.response.ApiLoginResponse;
import com.edot.api.response.ApiRegisterResponse;
import com.edot.service.UserService;
import com.edot.util.ObjectMergeUtils;
import com.edot.web.request.LoginRequest;
import com.edot.web.request.RegisterRequest;

import cn.wltg.http.HttpApiClient;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private HttpApiClient httpApiClient;

	@Override
	public ApiLoginResponse login(LoginRequest loginRequest) throws Exception {
		ApiLoginRequest apiLoginRequest = ObjectMergeUtils.merge(loginRequest, ApiLoginRequest.class);
        ApiLoginResponse response = httpApiClient.post(ApiUrls.LOGIN, apiLoginRequest, ApiLoginResponse.class);
        return response;
	}

	@Override
	public ApiRegisterResponse register(RegisterRequest registerRequest) throws Exception {
		return null;
	}

}
