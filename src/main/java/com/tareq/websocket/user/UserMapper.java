package com.tareq.websocket.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserCreatedResponse toUserCreatedResponseDto(User user, String status){
        return new UserCreatedResponse(status, user.getName(), user.getEmail());
    }

    public LoginResponse toUserLoginResponseDto(User user) {
        if(user == null){
            user = new User("","","","","","","",false,false);
        }
        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getImgUrl(),
                user.getPhnNumber(),
                user.getAddress(),
                user.getEmail(),
                user.isEnabled(),
                user.isOnline()
                );
    }
}
