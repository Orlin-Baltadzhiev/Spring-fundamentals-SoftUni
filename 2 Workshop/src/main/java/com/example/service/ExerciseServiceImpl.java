package com.example.service;

import com.example.model.Exercise;
import com.example.model.service.ExerciseServiceModel;
import com.example.repository.ExerciseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addEx(ExerciseServiceModel exerciseServiceModel) {
        exerciseRepository
                .save(modelMapper
                .map(exerciseServiceModel, Exercise.class));
    }
}
