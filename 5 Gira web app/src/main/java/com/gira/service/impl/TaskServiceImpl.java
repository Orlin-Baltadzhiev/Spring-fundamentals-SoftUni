package com.gira.service.impl;

import com.gira.model.entities.Task;
import com.gira.model.entities.User;
import com.gira.model.entities.enums.ProgressEnum;
import com.gira.model.service.TaskServiceModel;
import com.gira.model.service.UserServiceModel;
import com.gira.repositories.TaskRepository;
import com.gira.service.ClassificationsService;
import com.gira.service.TaskService;
import com.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ClassificationsService classificationsService;


    public TaskServiceImpl(TaskRepository taskRepository, UserService userService, ModelMapper modelMapper, ClassificationsService classificationsService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.classificationsService = classificationsService;
    }

    @Override
    public boolean add(TaskServiceModel taskServiceModel, HttpSession httpSession) {
        Object user = httpSession.getAttribute("user");
        UserServiceModel userServiceModel = modelMapper.map(
                user, UserServiceModel.class);

        User userToSet = userService.findByName(userServiceModel.getUsername());

        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setClassification(classificationsService
                .findByName(taskServiceModel
                        .getClassification()
                        .getClassificationNameEnum()));
        task.setProgressEnum(ProgressEnum.OPEN);
        task.setName(taskServiceModel.getName());
        task.setUser(userToSet);
        System.out.println(userToSet);

        try {
            taskRepository.save(task);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<Task> findAllTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    @Transactional
    public void changeProgress(String id) {
        Task task = this.taskRepository.findById(id).orElse(null);

        if (task != null) {
            String name = task.getProgressEnum().toString();

            switch (name) {
                case "OPEN" -> task.setProgressEnum(ProgressEnum.IN_PROGRESS);
                case "IN_PROGRESS" -> task.setProgressEnum(ProgressEnum.COMPLETED);
                case "COMPLETED" -> this.taskRepository.delete(task);
            }
        }


    }

}
