package com.example.service;

import com.example.model.service.ExerciseServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface ExerciseService {
    void addEx(ExerciseServiceModel exerciseServiceModel);

}
