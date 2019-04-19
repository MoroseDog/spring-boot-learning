package com.jj.learning.springboot.chapter31.controller;

import java.util.UUID;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jj.learning.springboot.chapter31.client.WsAuthorClient;
import com.jj.webservice.AuthorListRequest;
import com.jj.webservice.AuthorListResponse;
import com.jj.webservice.AuthorRequest;
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

    @RequestMapping(value = "/cxf/{method}", method = RequestMethod.GET)
    public Object cxf(@PathVariable String method, String name) throws Exception {
        // 獲取客戶端工廠類
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        // 創建client對象
        Client client = dcf.createClient("http://127.0.0.1:8080/ws/author.wsdl");

        AuthorListRequest listReq = new AuthorListRequest();
        listReq.setNonce(UUID.randomUUID().toString());

        AuthorRequest req = new AuthorRequest();
        req.setName(name);
        // 調用 第一個方法是operation 值，即調用方法，
        // 其後是調用參數。
        Object[] objects = new Object[0];
        // 相關 operation值 可以根據 client.getEndpoint().getBinding().getBindingInfo().getOperations(); 獲取
        // 有興趣可以看下 client.getEndpoint().getBinding().getBindingInfo()提供的一些方法。

        // 這裡就簡單的判斷了
        if ("authorList".equalsIgnoreCase(method)) {
            objects = client.invoke("authorList", listReq);
        }
        else {
            objects = client.invoke("author", req);
        }
        // 返回的對象objects[0]即為返回的值
        return objects[0];
    }

}
