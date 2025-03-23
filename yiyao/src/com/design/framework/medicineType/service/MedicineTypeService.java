package com.design.framework.medicineType.service;


import java.util.List;

import com.design.framework.medicineType.model.MedicineType;


public interface MedicineTypeService {
    /**
     *
     * FunName: login
     * Description : 用户登录
     * @param：String account,String password
     * @return MedicineType
     * @Author: pangsir
     * @Create Date: 2016-10-26
     */


    public void add(MedicineType medicineType);

    public List<MedicineType> list();

    int delete(Integer mt_id);

}
