package com.tareq.websocket.config;

import com.tareq.websocket.chat.WsMessage;
import com.tareq.websocket.user.LoginResponse;
import com.tareq.websocket.util.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Created by Tareq Sefati on 25-Dec-24
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messageTemplate;
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        LoginResponse user = (LoginResponse) headerAccessor.getSessionAttributes().get("connectedUser");
        if(user != null){
            log.info("User disconnected: {} - {}",user.name(), user.id());
            var wsMessage = WsMessage.builder()
                    .status(Status.LEAVE)
                    .user(user)
                    .build();
            messageTemplate.convertAndSend("/topic/public", wsMessage);
        }
    }

    // I think no need for this listener - for this time till now. May required later
//    @EventListener
//    public void handleWebSocketConnectListener(SessionConnectedEvent event){
//        log.info("Session connected log {}",event.getMessage().toString());
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        WsMessage wsMessage = (WsMessage) headerAccessor.getSessionAttributes().get("wsMessage");
//        if(wsMessage.getStatus().equals(Status.JOIN)){
//            LoginResponse connectedUser = (LoginResponse) wsMessage.getObject();
//            log.info("User connected: {} - {}",connectedUser.name(), connectedUser.id());
//            var wsMessage = WsMessage.builder()
//                    .status(Status.JOIN)
//                    .object(user)
//                    .build();
//            messageTemplate.convertAndSend("/topic/public", wsMessage);
//        }
//    }
}
