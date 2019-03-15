package com.jj.learning.springboot.chapter5.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelAttributeController {

    @RequestMapping(value = "/ma")
    public String modelAttribute(@ModelAttribute("id") String id) {
        return "ID:" + id;
    }

    @RequestMapping(value = "/ma/{id}")
    public String modelAttributeByPath(@ModelAttribute("id") String id) {
        return "ID:" + id;
    }

}
