package com.tareq.websocket.conversation;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConversationRepository extends MongoRepository<Conversation, String> {

    Optional<Conversation> findByParticipantIdAndAdjacentId(String participantId, String adjacentId);
}
