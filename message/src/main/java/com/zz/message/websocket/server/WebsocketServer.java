package com.zz.message.websocket.server;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/ws")
public class WebsocketServer {
    private static final Map<String, Session> SESSION_CACHE = new ConcurrentHashMap<>();


}
