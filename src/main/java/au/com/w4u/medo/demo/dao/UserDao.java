/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.dao;

import au.com.w4u.medo.demo.entity.User;
import au.com.w4u.medo.demo.dao.common.IOperations;

/**
 *
 * @author mly
 */
public interface UserDao extends IOperations<User> {
   User findUserByName(String name);
}
