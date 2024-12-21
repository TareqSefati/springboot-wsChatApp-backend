package com.tareq.websocket.user;

public record LoginRequest(
        String email,
        String password
) {
}
