package com.jj.learning.springboot.chapter30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jj.learning.springboot.chapter30.client.WsAuthorClient;
import com.jj.webservice.AuthorListResponse;
import com.jj.webservice.AuthorResponse;

@RestController
@RequestMapping("/author")
public class DemoController {

    @Autowired
    WsAuthorClient authorClient;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public AuthorResponse getAuthor(String name) {
        return authorClient.getAuthor(name);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public AuthorListResponse getAuthorList() {
        return authorClient.getAuthorList();
    }

}
