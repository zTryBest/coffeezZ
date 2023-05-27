package com.zz.message.websocket.controller;

import com.zz.message.websocket.domain.dto.GreetingDTO;
import com.zz.message.websocket.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {
    @Value("${test.value:jaskdfjkosad}")
    private String testValue;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GreetingDTO greeting(MessageDTO messageDTO){
        GreetingDTO greetingDTO = new GreetingDTO();
        greetingDTO.setContent(messageDTO.getUserName() + "message...");
        return greetingDTO;
    }

}
