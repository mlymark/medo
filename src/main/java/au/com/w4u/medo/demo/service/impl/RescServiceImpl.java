/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.w4u.medo.demo.service.impl;

import au.com.w4u.medo.demo.dao.RescDao;
import au.com.w4u.medo.demo.dao.common.IOperations;
import au.com.w4u.medo.demo.entity.Resc;
import au.com.w4u.medo.demo.service.RescService;
import au.com.w4u.medo.demo.service.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dell
 */
public class RescServiceImpl extends GenericService<Resc> implements RescService{
    @Autowired
    private RescDao rescDao;

    public void setRescDao(RescDao rescDao) {
        this.rescDao = rescDao;
    }
    
    
    public RescServiceImpl() {
        super();
    }

    @Override
    protected IOperations<Resc> getDao() {
        return this.rescDao;
    }
    
}
