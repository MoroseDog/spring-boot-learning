package com.jj.learning.springboot.chapter29.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jj.learning.springboot.chapter29.webservice.Author;
import com.jj.learning.springboot.chapter29.webservice.AuthorListRequest;
import com.jj.learning.springboot.chapter29.webservice.AuthorListResponse;
import com.jj.learning.springboot.chapter29.webservice.AuthorRequest;
import com.jj.learning.springboot.chapter29.webservice.AuthorResponse;
import com.jj.learning.springboot.chapter29.webservice.Sex;

@Endpoint
public class AuthorEndpoint {

    @PayloadRoot(namespace = WsConst.NAMESPACE_URI, localPart = "authorRequest")
    @ResponsePayload 
    public AuthorResponse getAuthor(@RequestPayload AuthorRequest authorReq){
        AuthorResponse resp = new AuthorResponse();
        Author author = new Author();
        author.setBirthday("1988-01-31");
        author.setName("姓名：" + authorReq.getName());
        author.setSex(Sex.FEMALE);
        author.getHobby().addAll(Arrays.asList("程式","桌遊","旅遊"));
        author.setDescription("描述：每天一文章筆記，加油。現在時間：" + new Date().getTime());
        resp.setAuthor(author);
        return resp;
    }
    
    @PayloadRoot(namespace = WsConst.NAMESPACE_URI, localPart = "authorListRequest")
    @ResponsePayload 
    public AuthorListResponse getAuthorList(@RequestPayload AuthorListRequest request){
        AuthorListResponse resp = new AuthorListResponse();
        Author author = new Author();
        author.setBirthday("1988-01-31");
        author.setName("姓名：J.J.Huang");
        author.setSex(Sex.FEMALE);
        author.getHobby().addAll(Arrays.asList("程式","桌遊","旅遊","電影"));
        author.setDescription("描述：每天一文章筆記，加油。現在時間：" + new Date().getTime());
        resp.getAuthor().add(author);
        resp.getAuthor().add(author);
        return resp;
    }
    
}
