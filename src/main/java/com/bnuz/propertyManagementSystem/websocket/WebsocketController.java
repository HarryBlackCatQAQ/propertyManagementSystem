package com.bnuz.propertyManagementSystem.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Harry
 * @Date: 2019-09-25 17:06
 * @Version 1.0
 */

@RestController
public class WebsocketController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    WebSocketServer webSocketServer;

    private void sendTopicMessage() {
        System.out.println(this.template);
        webSocketServer.onOpen(template,"/topic/getResponse");
    }


    @GetMapping(value = "/send")
    public String send(){
        sendTopicMessage();

        return "send ok";
    }

    @GetMapping(value = "/close")
    public String close(){
        webSocketServer.onClose();

        return "close ok";
    }
}
