package com.edot.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.edot.model.BizUserModel;
import com.edot.repository.BizUserRepository;

/**
 * 用户数据层实现
 * Created by tony on 16/1/23.
 */
@Repository
public class BizUserRepositoryImpl extends BaseRepositoryImpl<BizUserModel> implements BizUserRepository {

    @Override
    @Cacheable(value = "user-getByUsername", unless = "#result == null")
    public BizUserModel getByUsername(String username) {
        Criteria criteria = getSession().createCriteria(BizUserModel.class);
        criteria.add(Restrictions.eq("username", username));
        return (BizUserModel) criteria.uniqueResult();
    }

    @Override
    public BizUserModel login(String username) {
        Criteria criteria = getSession().createCriteria(BizUserModel.class);
        criteria.add(Restrictions.eq("username", username));
        return (BizUserModel) criteria.uniqueResult();
    }
}
