package com.coockies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LanguageController {

    private final String defaultLang = "bg";
    private final List<String> allLangs = List.of("en","bg","de");


    @PostMapping("/save")
    public String save(@RequestParam String lang,
                       HttpServletResponse response) {
    Cookie cookie = new Cookie("langCookie", lang);
    response.addCookie(cookie);
        return "redirect:/all";

    }

    @GetMapping("/all")
    public String allLangs(Model model,
                           @CookieValue(value = "langCookie", required = false,
                                   defaultValue =defaultLang)String lang){
        model.addAttribute("all", allLangs);
        model.addAttribute("preferredLang", lang);

       return "languages";
    }
}
