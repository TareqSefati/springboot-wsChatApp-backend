package com.tareq.websocket.controller;

import com.tareq.websocket.chat.WsMessage;
import com.tareq.websocket.user.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;
    @MessageMapping("/chat.connectUser")
    public void userOnConnected(@Payload WsMessage wsMessage, SimpMessageHeaderAccessor headerAccessor){
        LoginResponse connectedUser = wsMessage.getUser();
        headerAccessor.getSessionAttributes().put("connectedUser", connectedUser);
        messagingTemplate.convertAndSend("/topic/public", wsMessage);
        log.info("User: {} is connected.", connectedUser.name());
    }
}
