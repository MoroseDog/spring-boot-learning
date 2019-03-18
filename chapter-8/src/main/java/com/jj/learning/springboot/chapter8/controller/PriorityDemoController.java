package com.jj.learning.springboot.chapter8.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriorityDemoController {

    @Value("${test.priority}")
    private String priority;

    @RequestMapping(value = "/priority", method = RequestMethod.GET)
    public String getPropertiesPriority() {
        return "Config: " + priority;
    }

}
