package com.design.framework.inventory.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.inventory.dao.InventoryDao;
import com.design.framework.inventory.model.Inventory;
import com.design.framework.inventory.service.InventoryService;


@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryDao inventoryDao;
    
    
    @Override
    public List<Inventory> list() {
        return this.inventoryDao.list();
    }


    @Override
    public Inventory load(Integer m_id ) {
        return this.inventoryDao.load(m_id);
    }


    @Override
    public int update(Inventory inventory ) {
        return this.inventoryDao.update(inventory);
    }


	@Override
	public int add(Inventory inventory) {
		return this.inventoryDao.add(inventory);
	}
}
