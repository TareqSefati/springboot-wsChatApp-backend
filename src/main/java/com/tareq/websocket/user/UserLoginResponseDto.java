package com.tareq.websocket.user;

public record UserLoginResponseDto(
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
