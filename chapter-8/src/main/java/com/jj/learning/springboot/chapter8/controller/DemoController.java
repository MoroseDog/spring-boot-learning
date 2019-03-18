package com.jj.learning.springboot.chapter8.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${spring.jpa.databaseplatform}")
    private String database;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return database;
    }

}
