package com.jj.learning.springboot.chapter7.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomDemoController {

    @Value("${com.jj.secret}")
    private String secret;

    @Value("${com.jj.number}")
    private Integer number;

    @Value("${com.jj.bignumber}")
    private Long bignumber;

    @Value("${com.jj.uuid}")
    private String uuid;

    @Value("${com.jj.number.less.than.ten}")
    private Integer lessThanTen;

    @Value("${com.jj.number.int.range}")
    private Integer range;

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public String random() {
        StringBuffer sb = new StringBuffer();
        sb.append("secret:").append(secret).append("|");
        sb.append("number:").append(number).append("|");
        sb.append("bignumber:").append(bignumber).append("|");
        sb.append("uuid:").append(uuid).append("|");
        sb.append("lessThanTen:").append(lessThanTen).append("|");
        sb.append("range:").append(range);
        return sb.toString();
    }

}
