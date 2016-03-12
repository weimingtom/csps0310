package com.edot.repository;

import java.util.List;

import com.edot.model.BaseModel;
import com.edot.repository.provider.OrderProvider;
import com.edot.repository.provider.PageProvider;

/**
 * 数据层基类
 * Created by tony on 16/1/21.
 */
public interface BaseRepository<T extends BaseModel> {

    public T get(Long id);

    public List<T> listByPage(PageProvider pageProvider, OrderProvider... orderProviders);

    public List<T> list();

    public Long count();

    public void saveOrUpdate(T object);

    public void delete(T object);

    public void delete(Long id);

    public void delete(List<Long> ids);
}
