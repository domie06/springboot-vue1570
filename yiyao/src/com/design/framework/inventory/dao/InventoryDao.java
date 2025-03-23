/**
 * InventoryDao.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-09 22:02:43
 **/
package com.design.framework.inventory.dao;

import java.util.List;

import com.design.framework.inventory.model.Inventory;

public interface InventoryDao {
    int delete(Integer m_id);

    int add(Inventory inventory);

    Inventory load(Integer m_id);

    int update(Inventory inventory);

    List<Inventory> list();
}