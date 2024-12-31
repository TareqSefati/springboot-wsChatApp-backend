package com.tareq.websocket.chat;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Tareq Sefati on 29-Dec-24
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Chat {
    @Id
    private String id;
    private String senderId;
    private String receiverId;
    private String conversationHash;
    private String text;
    private String fileUrl;

    @CreatedDate
    private Date sentAt;
}
