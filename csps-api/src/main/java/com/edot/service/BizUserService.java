package com.edot.service;

import com.edot.model.BizUserModel;
import com.edot.web.exception.BizException;
import com.edot.web.request.RegisterRequest;

/**
 * 用户业务
 * Created by tony on 16/1/20.
 */
public interface BizUserService extends BaseService<BizUserModel> {

    public BizUserModel login(String username, String password) throws BizException;

    public BizUserModel register(RegisterRequest request) throws BizException;
}
