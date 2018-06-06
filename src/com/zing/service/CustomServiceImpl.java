package com.zing.service;

import com.zing.dao.CustomDao;
import com.zing.pojo.Customer;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
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
