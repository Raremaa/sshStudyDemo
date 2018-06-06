package com.zing.service;

import com.zing.dao.CustomDao;
import com.zing.pojo.Customer;

public class CustomServiceImpl implements CustomService {
    private CustomDao cd;
    @Override
    public void save(Customer customer) {
        cd.save(customer);
    }

    public void setCd(CustomDao cd) {
        this.cd = cd;
    }
}
