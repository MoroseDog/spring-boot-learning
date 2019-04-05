package com.jj.learning.springboot.chapter21.controller;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jj.learning.springboot.chapter21.domain.Demo;

@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(@Validated Demo demo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for (ObjectError error : errorList) {
                System.out.println(error.getDefaultMessage());
                return error.getDefaultMessage();
            }
        }
        return demo.getVersion();
    }

    @RequestMapping(value = "/demo/manvException", method = RequestMethod.POST)
    public String demoMethodArgumentNotValidException(@RequestBody @Validated Demo demo) {
        return demo.getVersion();
    }

    @RequestMapping(value = "/demo/bindException", method = RequestMethod.GET)
    public String demoBindException(@Validated Demo demo) {
        return demo.getVersion();
    }

}
