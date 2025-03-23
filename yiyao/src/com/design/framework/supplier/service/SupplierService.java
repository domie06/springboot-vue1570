package com.design.framework.supplier.service;


import java.util.List;

import com.design.framework.supplier.model.Supplier;


public interface SupplierService {
    /**
     *
     * FunName: login
     * Description : 用户登录
     * @param：String account,String password
     * @return Supplier
     * @Author: pangsir
     * @Create Date: 2016-10-26
     */


    public void add(Supplier supplier);

    public List<Supplier> list();

    int delete(Integer mt_id);

}
