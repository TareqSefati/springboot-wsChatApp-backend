package com.tareq.websocket.user;

public record LogoutRequest(
        String id,
        String email,
        String name
) {
}
