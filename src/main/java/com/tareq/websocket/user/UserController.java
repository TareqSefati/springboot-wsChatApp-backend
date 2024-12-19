package com.tareq.websocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("Test Success");
    }

    @PostMapping("/user")
    public ResponseEntity<UserCreatedResponse> saveUser(@RequestBody User user){
        try {
            var savedUser = userService.saveUser(user);
            return ResponseEntity.ok(mapper.toUserCreatedResponseDto(savedUser, "Success"));
        } catch (DuplicateKeyException exception){
            return ResponseEntity.ok(mapper.toUserCreatedResponseDto(user, "Duplicate key error!"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> userLogin(@RequestBody UserLoginDto userLoginDto){
        var loginResponse = mapper.toUserLoginResponseDto(userService.userLogin(userLoginDto));
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> allUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> userById(@PathVariable String id){
        var user = userService.findUserById(id);
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
//            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.NO_CONTENT, "Object missing")).build();
            return ResponseEntity.ofNullable(new User());
        }
    }

    @DeleteMapping("/user/id/{id}")
    public boolean deleteUserById(@PathVariable String id){
        return userService.deleteUserById(id);
    }

    @GetMapping("/user/email/{email}")
    public boolean checkUniqueEmail(@PathVariable String email){
        return userService.checkUniqueEmail(email);
    }

}
