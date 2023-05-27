package com.zz.message.websocket.controller;

import com.zz.message.websocket.domain.dto.GreetingDTO;
import com.zz.message.websocket.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.StringValueResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController implements EmbeddedValueResolverAware {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private String testValue;

    @GetMapping
    public String test() {
//        MessageDTO messageDTO = new MessageDTO();
//        messageDTO.setUserId("342");
//        messageDTO.setUserName("tests昨天");
//        greetingController.greeting(messageDTO);
//        GreetingDTO payload = new GreetingDTO();
//        payload.setContent("asdfsadfsda");
//        simpMessagingTemplate.convertAndSend("/topic/greetings", payload);
        return testValue;
        // 融合通信，建立群聊，如果收到群消息，那么群里所有的
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String s = resolver.resolveStringValue("${test.value}");
        testValue = s;
    }
}
