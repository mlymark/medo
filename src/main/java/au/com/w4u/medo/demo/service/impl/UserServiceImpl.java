/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.service.impl;

import au.com.w4u.medo.demo.dao.UserDao;
import au.com.w4u.medo.demo.dao.common.IOperations;
import au.com.w4u.medo.demo.entity.User;
import au.com.w4u.medo.demo.service.UserService;
import au.com.w4u.medo.demo.service.common.GenericService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mly
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends GenericService<User> implements UserService{

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    
    public UserServiceImpl() {
        super();
    }

    @Override
    protected IOperations<User> getDao() {
        return this.userDao;
    }

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

}
