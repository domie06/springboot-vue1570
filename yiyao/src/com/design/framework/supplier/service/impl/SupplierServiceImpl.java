package com.design.framework.supplier.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.supplier.dao.SupplierDao;
import com.design.framework.supplier.model.Supplier;
import com.design.framework.supplier.service.SupplierService;


@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;
    
    @Override
    public void add(Supplier supplier) {
        try{
            this.supplierDao.add(supplier);
        }catch (Exception e) {
            throw new RuntimeException("更新失败,原因为:"+e.getMessage());
        }
        
    }
    
    @Override
    public List<Supplier> list() {
        return this.supplierDao.list();
    }
    
    @Override
    public int delete(Integer mt_id) {
        return this.supplierDao.delete(mt_id);
    }
    

    
}
