package com.tareq.websocket.user;

import com.tareq.websocket.util.Status;

public record LogoutResponse(
        String id,
        String email,
        String name,
        Status status
) {
}
