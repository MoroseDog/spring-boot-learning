package com.jj.learning.springboot.chapter7.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArrayDemoController {

    @Value("${example.id}")
    private List<String> id;

    @Value("#{${example.pet.name}}")
    private Map<String, String> pet;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList() {
        return id.toString();
    }

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String getMap() {
        return pet.toString();
    }

}
