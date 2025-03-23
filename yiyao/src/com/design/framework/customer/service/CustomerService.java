package com.design.framework.customer.service;

import java.util.List;

import com.design.framework.customer.model.Customer;

public interface CustomerService {
    
    int delete(Integer s_id);

    int add(Customer customer);

    Customer load(Integer s_id);

    int update(Customer customer);

    List<Customer> list();
}
