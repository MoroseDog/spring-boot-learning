package com.jj.learning.springboot.chapter2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(){
        return "Hello World!";
    }
    
}
