package com.tareq.websocket.user;

import org.apache.catalina.startup.UserConfig;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserCreatedResponse toUserCreatedResponseDto(User user, String status){
        return new UserCreatedResponse(status, user.getName(), user.getEmail());
    }

    public UserLoginResponseDto toUserLoginResponseDto(User user) {
        if(user == null){
            user = new User("","","","","","","",false,false);
        }
        return new UserLoginResponseDto(
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
