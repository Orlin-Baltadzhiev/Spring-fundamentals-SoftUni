package com.gira.web;

import com.gira.model.binding.TaskAddBindingModel;
import com.gira.model.service.TaskServiceModel;
import com.gira.service.TaskService;
import com.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
     private final TaskService taskService;
     private final ModelMapper modelMapper;
     private final UserService userService;


    public TaskController(TaskService taskService, ModelMapper modelMapper,
                          UserService userService) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){

        if(httpSession.getAttribute("user")==null){
            return "redirect:login";
        }

        if(!model.containsAttribute("taskAddBindingModel")){
            model.addAttribute("taskAddBindingModel",new TaskAddBindingModel());
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpServletRequest httpServletRequest,
                             HttpSession httpSession){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskAddBindingModel",taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "redirect:/tasks/add";
        }

        boolean saved = taskService.add(modelMapper.map(taskAddBindingModel, TaskServiceModel.class), httpSession);


        return "redirect:/";
    }


    @GetMapping("/progress/{id}")
    public String changeProgress(@PathVariable String id) {
        taskService.changeProgress(id);

        return "redirect:/";
    }

}
