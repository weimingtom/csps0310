package com.edot.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import com.edot.model.BaseModel;
import com.edot.repository.BaseRepository;
import com.edot.repository.provider.OrderProvider;
import com.edot.repository.provider.PageProvider;

/**
 * 数据层基类抽象类
 * Created by tony on 16/1/23.
 */
public class BaseRepositoryImpl<T extends BaseModel> implements BaseRepository<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseRepositoryImpl() {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.entityClass = entityClass;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T get(Long id) {
        return (T) getSession().get(entityClass, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> listByPage(PageProvider pageProvider, OrderProvider... orderProviders) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (OrderProvider orderProvider : orderProviders) {
            if (orderProvider.getOrder() == OrderProvider.ORDER_ASC) {
                criteria.addOrder(Order.asc(orderProvider.getOrderColumn()));
            } else {
                criteria.addOrder(Order.desc(orderProvider.getOrderColumn()));
            }
        }
        criteria.setFirstResult((pageProvider.getCurrentPage() - 1) * pageProvider.getPageSize());
        criteria.setMaxResults(pageProvider.getPageSize());
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> list() {
        return getSession().createCriteria(entityClass).list();
    }

    @Override
    public Long count() {
        return (Long) getSession().createCriteria(entityClass).setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public void saveOrUpdate(T object) {
        getSession().saveOrUpdate(object);
    }

    @Override
    public void delete(T object) {
        getSession().delete(object);
    }

    @Override
    public void delete(Long id) {
        try {
            T t = entityClass.newInstance();
            t.setId(id);
            getSession().delete(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(List<Long> ids) {
        String sql = "delete from " + entityClass.getSimpleName() + " where id in ?";
        Query query = getSession().createQuery(sql);
        query.setParameterList("id", ids.toArray());
        query.executeUpdate();
    }
}
