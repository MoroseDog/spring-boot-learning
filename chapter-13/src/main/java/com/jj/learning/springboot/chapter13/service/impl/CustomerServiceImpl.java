package com.jj.learning.springboot.chapter13.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jj.learning.springboot.chapter13.domain.Customer;
import com.jj.learning.springboot.chapter13.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Customer customer) {
        jdbcTemplate.update("insert into customer(id, name, age, create_by, create_dt) values(?, ?, ?, ?, NOW())", customer.getId(), customer.getName(),
                customer.getAge(), "SYSTEM");
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from customer where name = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from customer", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from customer");
    }

}
