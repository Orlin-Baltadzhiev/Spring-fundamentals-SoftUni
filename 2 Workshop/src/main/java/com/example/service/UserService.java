package com.example.service;

import com.example.model.RoleNameEnum;
import com.example.model.User;
import com.example.model.service.UserServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel user);

    void logout();

    List<String> findAllUserNames();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    User findByUserId(Long id);
}
