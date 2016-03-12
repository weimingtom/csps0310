package com.edot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edot.model.BizUserModel;
import com.edot.repository.BaseRepository;
import com.edot.repository.BizUserRepository;
import com.edot.service.BizUserService;
import com.edot.web.exception.BizException;
import com.edot.web.request.RegisterRequest;

/**
 * 用户业务实现
 * Created by tony on 16/1/20.
 */
@Service
public class BizUserServiceImpl extends BaseServiceImpl<BizUserModel> implements BizUserService {

    @Autowired
    private BizUserRepository bizUserRepository;

    @Override
    protected BaseRepository<BizUserModel> getRepository() {
        return bizUserRepository;
    }

    @Override
    public BizUserModel login(String username, String password) throws BizException {
        BizUserModel user = bizUserRepository.login(username);
        if (user == null) {
            throw new BizException("user.not.exist");
        }
        if (! user.getPassword().equals(password)) {
            throw new BizException("user.password.wrong");
        }
        return user;
    }

    @Override
    public BizUserModel register(RegisterRequest request) throws BizException {
        BizUserModel user = bizUserRepository.getByUsername(request.getUsername());
        if (user != null) {
            throw new BizException("user.username.exist");
        }
        user = new BizUserModel();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setTelephone(request.getTelephone());
        bizUserRepository.saveOrUpdate(user);
        return user;
    }
}
