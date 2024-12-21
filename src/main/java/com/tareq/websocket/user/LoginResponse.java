package com.tareq.websocket.user;

public record LoginResponse(
        String id,
        String name,
        String imgUrl,
        String phnNumber,
        String address,
        String email,
        boolean enabled,
        boolean online
) {
}
