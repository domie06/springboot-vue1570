package com.design.framework.medicineType.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.medicineType.dao.MedicineTypeDao;
import com.design.framework.medicineType.model.MedicineType;
import com.design.framework.medicineType.service.MedicineTypeService;


@Service
public class MedicineTypeServiceImpl implements MedicineTypeService {
    @Autowired
    private MedicineTypeDao medicineTypeDao;
    
    @Override
    public void add(MedicineType medicineType) {
        try{
            this.medicineTypeDao.add(medicineType);
        }catch (Exception e) {
            throw new RuntimeException("更新失败,原因为:"+e.getMessage());
        }
        
    }
    
    @Override
    public List<MedicineType> list() {
        return this.medicineTypeDao.list();
    }
    
    @Override
    public int delete(Integer mt_id) {
        return this.medicineTypeDao.delete(mt_id);
    }
    

    
}
