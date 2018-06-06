package com.zing.dao;

import com.zing.pojo.Customer;

public interface CustomDao {
    Customer getById(Long id);

    void save(Customer customer);
}
