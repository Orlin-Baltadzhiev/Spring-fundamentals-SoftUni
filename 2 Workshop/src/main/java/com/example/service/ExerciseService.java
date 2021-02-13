package com.example.service;

import com.example.model.Exercise;
import com.example.model.service.ExerciseServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExerciseService {
    void addEx(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllExNames();

    boolean checkIfIsLate(String exercise);



    Exercise findByName(String name);
}
