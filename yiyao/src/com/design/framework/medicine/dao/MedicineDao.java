/**
 * MedicineDao.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-09 15:54:01
 **/
package com.design.framework.medicine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.design.framework.medicine.model.Medicine;

public interface MedicineDao {
    int delete(Integer m_id);

    int add(Medicine medicine);

    Medicine load(Integer m_id);

    int update(Medicine medicine);

    List<Medicine> list(@Param("key") String key);
}