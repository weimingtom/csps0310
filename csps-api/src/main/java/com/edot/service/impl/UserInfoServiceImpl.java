package com.edot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edot.model.UserInfoModel;
import com.edot.repository.BaseRepository;
import com.edot.repository.UserInfoRepository;
import com.edot.service.UserInfoService;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoModel> implements UserInfoService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	protected BaseRepository<UserInfoModel> getRepository() {
		// TODO Auto-generated method stub
		return userInfoRepository;
	}

}
