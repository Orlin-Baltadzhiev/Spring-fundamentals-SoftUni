package com.exam.service;

import com.exam.model.service.UserServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void register(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
