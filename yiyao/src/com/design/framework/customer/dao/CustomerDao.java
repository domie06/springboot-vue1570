/**
 * CustomerDao.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-04-14 09:51:27
 **/
package com.design.framework.customer.dao;

import java.util.List;

import com.design.framework.customer.model.Customer;

public interface CustomerDao {
    int delete(Integer c_id);

    int add(Customer customer);
    
    Customer load(Integer c_id);

    int update(Customer customer);
    
    List<Customer> list();
}