/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.dao.impl;

import au.com.w4u.medo.demo.dao.RescDao;
import au.com.w4u.medo.demo.dao.common.GenericDaoImpl;
import au.com.w4u.medo.demo.entity.Resc;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mly
 */
@Repository
public class RescDaoImpl extends GenericDaoImpl<Resc> implements RescDao{
    
    public RescDaoImpl() {
        super();
        setClazz(Resc.class);
    }
}
