/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.service;

import au.com.w4u.medo.demo.dao.common.IOperations;
import au.com.w4u.medo.demo.entity.User;

/**
 *
 * @author mly
 */
public interface UserService  extends IOperations<User>{
     User findUserByName(String name);
}
