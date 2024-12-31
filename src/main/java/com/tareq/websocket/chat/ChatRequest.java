package com.tareq.websocket.chat;

import com.tareq.websocket.util.Status;

import java.util.Date;

public record ChatRequest(
        String senderId,
        String receiverId,
        String conversationHash,
        Status chatOrder,
        Date startDate,
        Date endDate
) {
}
