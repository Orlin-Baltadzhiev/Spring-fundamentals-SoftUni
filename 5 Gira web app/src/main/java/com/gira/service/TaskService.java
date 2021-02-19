package com.gira.service;

import com.gira.model.entities.Task;
import com.gira.model.service.TaskServiceModel;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface TaskService {

    boolean add(TaskServiceModel taskServiceModel, HttpSession httpSession);

    List<Task> findAllTasks();

    void changeProgress(String id);

}
