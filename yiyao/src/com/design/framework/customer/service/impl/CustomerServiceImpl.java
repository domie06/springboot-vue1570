package com.design.framework.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.design.framework.customer.dao.CustomerDao;
import com.design.framework.customer.model.Customer;
import com.design.framework.customer.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public int delete(Integer s_id) {
        return this.customerDao.delete(s_id);
    }

    @Override
    public int add(Customer customer) {
        return this.customerDao.add(customer);
    }

    @Override
    public Customer load(Integer s_id) {
        return this.customerDao.load(s_id);
    }

    @Override
    public int update(Customer customer) {
        return this.customerDao.update(customer);
    }

    @Override
    public List<Customer> list() {
        return this.customerDao.list();
    }

}
