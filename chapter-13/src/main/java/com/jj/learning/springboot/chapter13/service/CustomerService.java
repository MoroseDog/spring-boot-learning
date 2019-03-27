package com.jj.learning.springboot.chapter13.service;

import com.jj.learning.springboot.chapter13.domain.Customer;

public interface CustomerService {

    /**
     * 新增一個用戶  
     * 2019年3月26日
     * @param customer
     *
     */
    void create(Customer customer);

    /**
     * 根據name刪除一個用戶
     * 2019年3月26日
     * @param name
     *
     */
    void deleteByName(String name);

    /**
     * 獲取用戶總數
     * 2019年3月26日
     * @return
     *
     */
    Integer getAllUsers();

    /**
     * 刪除所有用戶
     * 2019年3月26日
     *
     */
    void deleteAllUsers();

}