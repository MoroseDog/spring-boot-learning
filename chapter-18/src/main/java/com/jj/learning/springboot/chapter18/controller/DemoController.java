package com.jj.learning.springboot.chapter18.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jj.learning.springboot.chapter18.exception.MyException;

@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() throws Exception {
        throw new Exception("錯誤");
    }
    
    @RequestMapping(value = "/demoJson", method = RequestMethod.GET)
    public String demoJson() throws Exception {
        throw new MyException("錯誤2");
    }
    
}
