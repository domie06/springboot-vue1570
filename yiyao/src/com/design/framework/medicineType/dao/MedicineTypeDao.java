/**
 * MedicineTypeDao.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-09 01:06:29
 **/
package com.design.framework.medicineType.dao;

import java.util.List;

import com.design.framework.medicineType.model.MedicineType;

public interface MedicineTypeDao {
    int delete(Integer mt_id);

    int add(MedicineType medicineType);

    MedicineType load(Integer mt_id);

    int update(MedicineType medicineType);
    
    List<MedicineType> list();
}