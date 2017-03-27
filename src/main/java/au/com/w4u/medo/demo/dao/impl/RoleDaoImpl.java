/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.dao.impl;

import au.com.w4u.medo.demo.dao.RoleDao;
import au.com.w4u.medo.demo.dao.common.GenericDaoImpl;
import au.com.w4u.medo.demo.entity.Role;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mly
 */
@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao{
    
    public RoleDaoImpl() {
        super();
        setClazz(Role.class);
    }
}
