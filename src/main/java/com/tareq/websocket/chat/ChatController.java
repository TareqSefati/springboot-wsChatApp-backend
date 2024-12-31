package com.tareq.websocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tareq Sefati on 30-Dec-24
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class ChatController {
    private final ChatService service;

    @PostMapping("/chat")
    public ResponseEntity<Chat> saveChat(@RequestBody Chat chat){
        return ResponseEntity.ok(service.saveChat(chat));
    }

    @PostMapping("/chat/chats-by-conversation-hash")
    public ResponseEntity<List<Chat>> allChatByConversationHash(@RequestBody ChatRequest request){
        return ResponseEntity.ok(service.findAllByConversationHash(request));
    }
}
