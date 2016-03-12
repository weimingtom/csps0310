package com.edot.service;

import com.edot.api.response.ApiLoginResponse;
import com.edot.api.response.ApiRegisterResponse;
import com.edot.web.request.LoginRequest;
import com.edot.web.request.RegisterRequest;

public interface UserService extends BaseService {
	public ApiLoginResponse login(LoginRequest loginRequest) throws Exception;
	
	public ApiRegisterResponse register(RegisterRequest registerRequest) throws Exception;
}
