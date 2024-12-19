package com.tareq.websocket.user;
public record UserCreatedResponse(
        String status,
        String name,
        String email
) {
}
