package com.example.service;

import com.example.model.Homework;
import com.example.repository.HomeworkRepository;
import com.example.security.CurrentUser;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExerciseService exerciseService, CurrentUser currentUser, UserService userService) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {
        Homework homeWork = new Homework();

        homeWork.setGitAddress(gitAddress);
        homeWork.setAddedOn(LocalDateTime.now());
        homeWork.setExercise(exerciseService.findByName(exercise));
        homeWork.setAuthor(userService.findByUserId(currentUser.getId()));

        homeworkRepository.save(homeWork);


    }
}
