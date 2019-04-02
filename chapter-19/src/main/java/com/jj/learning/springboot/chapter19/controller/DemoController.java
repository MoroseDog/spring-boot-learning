package com.jj.learning.springboot.chapter19.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jj.learning.springboot.chapter19.domain.Customer;

@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(@Valid Customer customer) {
        return "姓名：" + customer.getName() + ", 年齡：" + customer.getAge() + ", 創建者：" + customer.getCreateBy();
    }

}
