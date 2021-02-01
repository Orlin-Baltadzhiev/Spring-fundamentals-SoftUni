package bg.softUni.mobilele.web;

import bg.softUni.mobilele.model.service.UserLoginServiceModel;
import bg.softUni.mobilele.security.CurrentUser;
import bg.softUni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users//login")
    public String showLogin(Model model) {
        return "auth-login";
    }

    @PostMapping("/users//login")
    public String login(UserLoginServiceModel model) {
    if(userService.authenticate(model.getUserName(), model.getPassword())){
        userService.loginUser(model.getUserName());
        return "redirect:/";
    } else  {
        return "redirect:/users/login";
    }

    }
}
