package com.jj.learning.springboot.chapter28.controller;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.jj.learning.springboot.chapter28.utils.WebSocketUtil;

@Component
@ServerEndpoint(value = "/WebSocketServer/{usernick}")
public class WebSocketController {

    @OnOpen
    public void onOpen(@PathParam(value = "usernick") String userNick, Session session) {
        String message = "有新成員[" + userNick + "]加入聊天室!";
        System.out.println(message);
        WebSocketUtil.addSession(userNick, session);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnClose
    public void onClose(@PathParam(value = "usernick") String userNick, Session session) {
        String message = "成員[" + userNick + "]退出聊天室!";
        System.out.println(message);
        WebSocketUtil.remoteSession(userNick);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnMessage
    public void OnMessage(@PathParam(value = "usernick") String userNick, String message) {
        String info = "成員[" + userNick + "]：" + message;
        System.out.println(info);
        WebSocketUtil.sendMessageForAll(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("錯誤:" + throwable);
        try {
            session.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }

}
