package ru.smurtazin.frsprb2book.security.simplewebtry1.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.smurtazin.frsprb2book.security.simplewebtry1.model.User;

import javax.validation.Valid;

@Log
@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registrForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String backRegistr(@Valid User user, BindingResult result) {
        log.info("Registr User: " + user);
        if(result.hasErrors()) return "registration";
        return "redirect:/home";
    }

}
