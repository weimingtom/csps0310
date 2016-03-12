package com.edot.repository.impl;

import org.springframework.stereotype.Repository;

import com.edot.model.UserInfoModel;
import com.edot.repository.UserInfoRepository;

@Repository
public class UserInfoRepositoryImpl extends BaseRepositoryImpl<UserInfoModel> implements UserInfoRepository {

}
