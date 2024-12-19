package com.tareq.websocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User userLogin(UserLoginDto userLoginDto){
        return userRepository.findByEmailAndPassword(userLoginDto.email(), userLoginDto.password()).orElse(null);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(String id){
        return userRepository.findById(id).orElse(null);
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    public boolean deleteUserById(String id){
        userRepository.deleteById(id);
        return findUserById(id) == null;
    }
    public List<User> findAllUserByOnlineStatus(boolean onlineStatus){
        return userRepository.findAllByOnline(onlineStatus);
    }

    public List<User> findAllUserByEnableStatus(boolean enableStatus){
        return userRepository.findAllByEnabled(enableStatus);
    }

    public void changeOnlineStatusAndUpdateDb(User user, boolean onlineStatus){
        user.setOnline(onlineStatus);
        userRepository.save(user);
    }

    public void changeUserEnabledAndUpdateDb(User user, boolean userEnabled){
        user.setEnabled(userEnabled);
        userRepository.save(user);
    }

    public boolean checkUniqueEmail(String email){
        var user = findUserByEmail(email);
        return user == null;
    }
}
