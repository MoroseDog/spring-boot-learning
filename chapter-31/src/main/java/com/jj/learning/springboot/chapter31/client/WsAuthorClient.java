package com.jj.learning.springboot.chapter31.client;

import java.util.UUID;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.jj.webservice.AuthorListRequest;
import com.jj.webservice.AuthorListResponse;
import com.jj.webservice.AuthorRequest;
import com.jj.webservice.AuthorResponse;

public class WsAuthorClient extends WebServiceGatewaySupport {

    // 獲取作者信息
    public AuthorResponse getAuthor(String name) {
        AuthorRequest req = new AuthorRequest();
        req.setName(name);
        // 使用 marshalSendAndReceive 進行調用
        return (AuthorResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    // 獲取作者列表信息
    public AuthorListResponse getAuthorList() {
        AuthorListRequest request = new AuthorListRequest();
        request.setNonce(UUID.randomUUID().toString());
        return (AuthorListResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}