package com.example.service;

import com.example.model.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);
}
