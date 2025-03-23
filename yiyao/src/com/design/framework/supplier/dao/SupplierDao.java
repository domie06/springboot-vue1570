/**
 * SupplierDao.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-14 09:52:04
 **/
package com.design.framework.supplier.dao;

import java.util.List;

import com.design.framework.supplier.model.Supplier;

public interface SupplierDao {
    int delete(Integer s_id);

    int add(Supplier supplier);

    Supplier load(Integer s_id);

    int update(Supplier supplier);
    
    List<Supplier> list();
}