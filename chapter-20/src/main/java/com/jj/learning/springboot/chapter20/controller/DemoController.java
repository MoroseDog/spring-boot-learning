package com.jj.learning.springboot.chapter20.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jj.learning.springboot.chapter20.domain.Customer;

@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(@Validated Customer customer) {
        return "姓名：" + customer.getName() + ", 年齡：" + customer.getAge() + ", 創建者：" + customer.getCreateBy();
    }

}
