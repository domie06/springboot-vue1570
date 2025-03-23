package com.design.framework.inventory.service;


import java.util.List;

import com.design.framework.inventory.model.Inventory;



public interface InventoryService {



    public List<Inventory> list();

    Inventory load(Integer m_id);
    
    int update(Inventory inventory);
    
    int add(Inventory inventory);
}
