package ru.smurtazin.frsprb2book.security.simplewebtry1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello Spring MVC!!");
        return "home";
    }

    /*@PostMapping("/users")
    public String createUser(User user) {
        user
    }*/

}
