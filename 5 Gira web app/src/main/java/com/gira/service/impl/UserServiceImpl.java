package com.gira.service.impl;

import com.gira.model.entities.User;
import com.gira.model.service.UserServiceModel;
import com.gira.repositories.UserRepository;
import com.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private UserServiceModel userServiceModel;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(UserServiceModel userServiceModel) {
        this.userRepository.save(modelMapper
                .map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email,password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByUsername(username);
    }




}
