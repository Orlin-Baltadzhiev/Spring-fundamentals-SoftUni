package com.example.web;

import com.example.model.RoleNameEnum;
import com.example.service.UserService;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/role")
public class RoleController {
    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("names",userService.findAllUserNames());
        return "role-add";
    }

    @PostMapping("/add")
    public String addConfirm(@RequestParam String username,
                             @RequestParam String role){

     userService.changeRole(username,
             RoleNameEnum.valueOf(role.toUpperCase()));

        return "redirect:/";
    }
}
