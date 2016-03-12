package com.edot.service;

import java.util.List;

import com.edot.model.BaseModel;
import com.edot.repository.provider.OrderProvider;
import com.edot.repository.provider.PageProvider;

/**
 * 业务基类
 * Created by tony on 16/1/23.
 */
public interface BaseService<T extends BaseModel> {

    public T get(Long id);

    public List<T> listByPage(PageProvider pageProvider, OrderProvider... orderProvider);

    public List<T> list();

    public Long count();

    public void saveOrUpdate(T object);

    public void delete(T object);

    public void delete(Long id);

    public void delete(List<Long> ids);

}
