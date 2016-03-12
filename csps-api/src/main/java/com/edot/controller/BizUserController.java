package com.edot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edot.model.BizUserModel;
import com.edot.service.BizUserService;
import com.edot.util.ObjectMergeUtils;
import com.edot.web.request.LoginRequest;
import com.edot.web.request.RegisterRequest;
import com.edot.web.response.LoginResponse;
import com.edot.web.response.RegisterResponse;

/**
 * 用户控制
 * Created by tony on 16/1/20.
 */
@Controller
@RequestMapping("/user")
public class BizUserController extends BaseController {

    @Autowired
    private BizUserService bizUserService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        BizUserModel user = bizUserService.login(loginRequest.getUsername(), loginRequest.getPassword());
        return ObjectMergeUtils.merge(user, LoginResponse.class);
    }

    @ResponseBody
    @RequestMapping(value = "/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) throws Exception {
        BizUserModel user = bizUserService.register(registerRequest);
        return ObjectMergeUtils.merge(user, RegisterResponse.class);
    }
}
