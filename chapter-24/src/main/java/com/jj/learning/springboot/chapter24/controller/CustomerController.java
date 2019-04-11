package com.jj.learning.springboot.chapter24.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jj.learning.springboot.chapter24.domain.Customer;
import com.jj.learning.springboot.chapter24.service.CustomerService;

@RestController
@RequestMapping(value = "/cus")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(Customer customer) {
        customer = customerService.saveCustomer(customer);
        return "新增成功，返回用戶id為：" + customer.getId();
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Customer findUser(@PathVariable Long id) {
        return customerService.findOneById(id);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delUser(@RequestParam("id") Long id) {
        customerService.delCustomerById(id);
        return "用戶id為：" + id + "，已被删除!";
    }

    @RequestMapping(value = "/find/{name}/{age}", method = RequestMethod.GET)
    public List<Customer> findUserByCodeAndName(@PathVariable("name") String name, @PathVariable("age") int age) {
        return customerService.findByNameAndAge(name, age);
    }

}
