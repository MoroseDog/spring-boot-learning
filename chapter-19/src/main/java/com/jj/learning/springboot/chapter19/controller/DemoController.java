package com.jj.learning.springboot.chapter19.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

    @RequestMapping(value = "/demo/bindingResult", method = RequestMethod.GET)
    public String demo(@Valid Customer customer, BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for (ObjectError error : errorList) {
                System.out.println(error.getDefaultMessage());
                sb.append(error.getDefaultMessage());
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
        }
        return "姓名：" + customer.getName() + ", 年齡：" + customer.getAge() + ", 創建者：" + customer.getCreateBy();
    }

}
