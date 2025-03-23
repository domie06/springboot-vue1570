package com.design.framework.medicine.service;

import java.util.List;

import com.design.framework.medicine.model.Medicine;

public interface MedicineService {
    
    int delete(Integer m_id);

    int add(Medicine medicine);

    Medicine load(Integer m_id);

    int update(Medicine medicine);

    List<Medicine> list(String key);
}
