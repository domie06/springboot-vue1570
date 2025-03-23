package com.design.framework.medicine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.inventory.dao.InventoryDao;
import com.design.framework.inventory.model.Inventory;
import com.design.framework.medicine.dao.MedicineDao;
import com.design.framework.medicine.model.Medicine;
import com.design.framework.medicine.service.MedicineService;
@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    private MedicineDao medicineDao;
    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public int delete(Integer m_id ) {
        this.inventoryDao.delete(m_id);
        return this.medicineDao.delete(m_id);
    }

    @Override
    public int add(Medicine medicine ) {
        Inventory inventory = new Inventory();
        inventory.setNum(0);
        this.inventoryDao.add(inventory);
        return this.medicineDao.add(medicine);
    }

    @Override
    public Medicine load(Integer m_id ) {
        return this.medicineDao.load(m_id);
    }

    @Override
    public int update(Medicine medicine ) {
        return this.medicineDao.update(medicine);
    }

    @Override
    public List<Medicine> list(String key) {
        return this.medicineDao.list(key);
    }

}
