package com.jj.learning.springboot.chapter6.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${com.jj.name}")
    private String name;

    @Value("${com.jj.want}")
    private String want;

    @Value("${com.jj.sentence}")
    private String sentence;

    @Value("${com.jj.my.age}")
    private String age;

    @Value("${com.jj.my.gender}")
    private String gender;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return name + "," + want;
    }

    @RequestMapping(value = "/sentence", method = RequestMethod.GET)
    public String sentence() {
        return sentence;
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public String myProperties() {
        return "性別：" + gender + ",今年" + age;
    }

}
