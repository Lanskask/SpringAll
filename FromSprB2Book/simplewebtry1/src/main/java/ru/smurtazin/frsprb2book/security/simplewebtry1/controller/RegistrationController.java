package ru.smurtazin.frsprb2book.security.simplewebtry1.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.smurtazin.frsprb2book.security.simplewebtry1.model.User;

@Log
@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registrForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String backRegistr(User user) {
        log.info("Registr User: " + user);
        return "redirect:/login";
    }

}
