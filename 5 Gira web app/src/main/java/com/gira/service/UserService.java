package com.gira.service;

import com.gira.model.entities.User;
import com.gira.model.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void add(UserServiceModel userServiceModel);

    UserServiceModel findByEmailAndPassword(String email, String password);

    User findByName(String username);

}
