package com.edot.service.impl;

import java.util.List;

import com.edot.model.BaseModel;
import com.edot.repository.BaseRepository;
import com.edot.repository.provider.OrderProvider;
import com.edot.repository.provider.PageProvider;
import com.edot.service.BaseService;

/**
 * 业务基类抽象类
 * Created by tony on 16/1/23.
 */
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    protected abstract BaseRepository<T> getRepository();

    @Override
    public T get(Long id) {
        return getRepository().get(id);
    }

    @Override
    public List<T> listByPage(PageProvider pageProvider, OrderProvider... orderProviders) {
        return getRepository().listByPage(pageProvider, orderProviders);
    }

    @Override
    public List<T> list() {
        return getRepository().list();
    }

    @Override
    public Long count() {
        return getRepository().count();
    }

    @Override
    public void saveOrUpdate(T object) {
        getRepository().saveOrUpdate(object);
    }

    @Override
    public void delete(T object) {
        getRepository().delete(object);
    }

    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }

    @Override
    public void delete(List<Long> ids) {
        getRepository().delete(ids);
    }
}
