package com.tareq.websocket.conversation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Tareq Sefati on 28-Dec-24
 */
@Service
@RequiredArgsConstructor
public class ConversationService {
    private final ConversationRepository repository;

    public Conversation saveConversation(Conversation conversation){
        return repository.save(conversation);
    }

    public Conversation findConversationByIds(String participantId, String adjacentId){
        return repository.findByParticipantIdAndAdjacentId(participantId, adjacentId)
                .orElse(repository.findByParticipantIdAndAdjacentId(adjacentId, participantId).orElse(null));
    }
}
