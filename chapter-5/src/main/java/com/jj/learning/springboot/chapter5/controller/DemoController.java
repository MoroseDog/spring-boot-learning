package com.jj.learning.springboot.chapter5.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @ModelAttribute
    void beforeInvokingHandlerMethod(HttpServletRequest request) {
        request.setAttribute("id", "Hello world!");
    }
    
    @RequestMapping(value = "/path/{id}", method = RequestMethod.GET)
    public String pathVariable(@PathVariable("id") String id){
        return "ID:" + id;
    }
    
    @RequestMapping(value = "/path", method = RequestMethod.GET)
    public String requestParam(@RequestParam("id") String id){
        return "ID:" + id;
    }

    @RequestMapping(value = "/req/attr", method = RequestMethod.GET)
    public String requestAttribute(@RequestAttribute("id") String id){
        return "ID:" + id;
    }
    
}
