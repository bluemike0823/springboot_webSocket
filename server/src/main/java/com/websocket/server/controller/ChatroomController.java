package com.websocket.server.controller;

import com.websocket.server.model.ChatClientModel;
import com.websocket.server.model.ServerResponseModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatroomController {

    @MessageMapping("/messageControl")
    @SendTo("topic/getResponse")
    public ServerResponseModel said(ChatClientModel responseMessage) throws InterruptedException {
        Thread.sleep(3000);
        ServerResponseModel model = new ServerResponseModel();
        model.setResponseMessage("welcome from mikey : " + responseMessage.getClientname());
        return model;
    }


}
