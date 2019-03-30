package com.jj.learning.springboot.chapter16.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    
    List<Customer> getAllCustomer();
    
    Customer getCustomerByName(String name);

    Integer addCustomer(Customer customer);

    Integer updateCustomerById(Customer customer);

    Integer deleteAllCustomer();
    
    Integer deleteCustomerById(Long id);

}
