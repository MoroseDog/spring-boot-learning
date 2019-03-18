package com.jj.learning.springboot.chapter8.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvDemoController {

    @Value("${PATH}")
    private String path;
    
    @Value("${spring.test.env}")
    private String testEnv;
    
    @RequestMapping(value = "/env", method = RequestMethod.GET)
    public String getEnv(){
//        // 用於列出系統上的環境變數
//        Map<String, String> env = System.getenv();
//        for (String envName : env.keySet()) {
//            System.out.format("%s=%s%n", envName, env.get(envName));
//        }
        return this.path;
    }
    
    @RequestMapping(value = "/env/test", method = RequestMethod.GET)
    public String getTestEnv(){
        return this.testEnv;
    }
    
}
