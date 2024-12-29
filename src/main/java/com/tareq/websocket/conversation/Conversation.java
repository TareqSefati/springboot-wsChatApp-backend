package com.tareq.websocket.conversation;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Tareq Sefati on 28-Dec-24
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Conversation {
    @Id
    private String id;
    private String participantId;
    private String adjacentId;
    private String lastMessage;
    private String conversationHash;

    @CreatedDate
    private Date createdAt;
}
