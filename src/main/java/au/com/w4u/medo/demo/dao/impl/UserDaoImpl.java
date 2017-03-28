/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.dao.impl;

import au.com.w4u.medo.demo.dao.UserDao;
import au.com.w4u.medo.demo.dao.common.GenericDaoImpl;
import au.com.w4u.medo.demo.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mly
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{
    
    public UserDaoImpl() {
        super();
        setClazz(User.class);
    }

    @Override
    public User findUserByName(String name) {
        Query query = this.getEntityManager().createQuery("select user from User user where user.username = :username");
        query.setParameter("username", name);
        return (User) query.getSingleResult();
    }
   
}
