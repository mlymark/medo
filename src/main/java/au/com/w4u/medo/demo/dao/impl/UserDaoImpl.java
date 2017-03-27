/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.dao.impl;

import au.com.w4u.medo.demo.dao.UserDao;
import au.com.w4u.medo.demo.dao.common.GenericDaoImpl;
import au.com.w4u.medo.demo.entity.User;
import java.util.List;
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
        List<User> users = (List<User>)getCurrentSession().createQuery("from User u where u.username='"+name+"'").list();
        if(users.size() > 0){
            return users.get(0);
        }else {
            return null;
        }
    }
    
}
