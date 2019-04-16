package com.jj.learning.springboot.chapter28.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;

public class WebSocketUtil {

    private static final Map<String, Session> ONLINE_SESSION = new ConcurrentHashMap<>();

    // 新增紀錄Session
    public static void addSession(String userNick, Session session) {
        ONLINE_SESSION.put(userNick, session);
    }

    // 移除Session
    public static void remoteSession(String userNick) {
        ONLINE_SESSION.remove(userNick);
    }

    // 發送訊息
    public static void sendMessage(Session session, String message) {
        if (session == null) {
            return;
        }
        Async async = session.getAsyncRemote();
        async.sendText(message);
    }

    // 發送群體訊息
    public static void sendMessageForAll(String message) {
        ONLINE_SESSION.forEach((sessionId, session) -> sendMessage(session, message));
    }
}
