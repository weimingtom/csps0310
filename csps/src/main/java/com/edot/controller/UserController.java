package com.edot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edot.api.response.ApiRegisterResponse;
import com.edot.service.UserService;
import com.edot.util.ObjectMergeUtils;
import com.edot.web.request.RegisterRequest;
import com.edot.web.response.RegisterResponse;
import com.edot.web.response.UserInfoResponse;

/**
 * 用户
 * Created by tony on 16/2/3.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterResponse register(@Valid @RequestBody RegisterRequest registerRequest) throws Exception {
        ApiRegisterResponse apiRegisterResponse = userService.register(registerRequest);
        RegisterResponse response = ObjectMergeUtils.merge(apiRegisterResponse, RegisterResponse.class);
        return response;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public UserInfoResponse getInfo(@RequestParam(value = "username") String username,
                                    @RequestParam(value = "password") String password,
                                    HttpServletRequest request) throws Exception {
        UserInfoResponse response = new UserInfoResponse();
        response.setUsername("chentao");//getUser(request).getUsername());
        response.setTelephone("18602625352");
        return response;
    }
}
