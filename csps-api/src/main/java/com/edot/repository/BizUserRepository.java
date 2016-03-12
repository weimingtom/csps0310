package com.edot.repository;

import com.edot.model.BizUserModel;

/**
 * 用户数据层
 * Created by tony on 16/1/23.
 */
public interface BizUserRepository extends BaseRepository<BizUserModel> {

    public BizUserModel getByUsername(String username);

    public BizUserModel login(String username);
}
