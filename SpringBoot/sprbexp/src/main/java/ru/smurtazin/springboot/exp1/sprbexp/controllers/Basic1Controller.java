package ru.smurtazin.springboot.exp1.sprbexp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Basic1Controller {

    @RequestMapping(value="/basic1", method= RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("message", "Hello Spring MVC!!");
        return "basic1";
    }

}
