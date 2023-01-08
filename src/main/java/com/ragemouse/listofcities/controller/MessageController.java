package com.ragemouse.listofcities.controller;

import com.ragemouse.listofcities.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message message(Message messageFromClient) throws Exception{
        messageFromClient.setMessage("hello");
        messageFromClient.setContent("Pidor");
        Thread.sleep(3000);
        return messageFromClient;
    }
}
