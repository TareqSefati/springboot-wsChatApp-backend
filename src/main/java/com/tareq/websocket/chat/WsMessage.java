package com.tareq.websocket.chat;

import com.tareq.websocket.user.LoginResponse;
import com.tareq.websocket.util.Status;
import lombok.*;

/**
 * Created by Tareq Sefati on 25-Dec-24
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WsMessage {
    private Status status;
    private String content;
    private LoginResponse user;
}
