package com.tareq.websocket.conversation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tareq Sefati on 28-Dec-24
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class ConversationController {
    private final ConversationService service;

    @PostMapping("/conversation")
    public ResponseEntity<Conversation> saveConversation(@RequestBody Conversation conversation){
        return ResponseEntity.ok(service.saveConversation(conversation));
    }
    @PostMapping("/conversation/byIds")
    public ResponseEntity<Conversation> getConversationByIds
            (@RequestBody ConversationReq req){
        String id1 = req.participantId();
        String id2 = req.adjacentId();
        return ResponseEntity.ok(service.findConversationByIds(id1, id2));

    }
}
