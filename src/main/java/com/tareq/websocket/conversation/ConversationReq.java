package com.tareq.websocket.conversation;

public record ConversationReq(
        String participantId,
        String adjacentId
) {
}
