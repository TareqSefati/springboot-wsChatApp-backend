package com.tareq.websocket.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tareq Sefati on 30-Dec-24
 */
@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository repository;

    public Chat saveChat(Chat chat){
        return repository.save(chat);
    }

    public List<Chat> findAllByConversationHash(ChatRequest request){
        return repository.findAllByConversationHash(request.conversationHash());
    }
}
