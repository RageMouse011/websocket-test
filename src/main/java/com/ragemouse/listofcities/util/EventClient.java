package com.ragemouse.listofcities.util;

import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class EventClient {

    public static void createEventClient(String allCities){
        String uri = "ws://localhost:2711/events";

        StandardWebSocketClient client = new StandardWebSocketClient();

        try{
            EventHandler socket = new EventHandler();
            CompletableFuture<WebSocketSession> fut =  client.execute(socket,uri);
            WebSocketSession session;
            session = fut.get();
            session.sendMessage(new TextMessage(allCities));
            session.close();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
        }
    }
}
