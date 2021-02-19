package com.gira.web;

import com.gira.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final  TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession httpSession){

        if (httpSession.getAttribute("user")==null){
            return "index";
        } else {
            model.addAttribute("task",taskService.findAllTasks());
        }

        return "home";
    }
}
