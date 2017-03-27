/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.dao.common;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mly
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class GenericDaoImpl<T extends Serializable> implements IOperations<T> {
    
    private Class<T> clazz ;

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = Preconditions.checkNotNull(clazzToSet);
    }
  
    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public final T findOne(final Integer id) {
        return (T)getCurrentSession().get(clazz, id);
    }
    
    @Override
    public final T get(final Integer id) {
        return (T)getCurrentSession().load(clazz, id);
    }

    @Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final Integer entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    @Override
    public final Integer save(T entity) {
        Preconditions.checkNotNull(entity);
        return (Integer) getCurrentSession().save(entity);
    }
    
}
