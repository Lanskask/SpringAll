package ru.smurtazin.springboot.exp1.sprbexp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreatingController {

    @RequestMapping("/greeting")
    public String greeting(
            @RequestParam(value="name",required=false,defaultValue="World")
                    String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/fuck_you")
    public String fuckYou(
            @RequestParam(value="name", required=false, defaultValue="You")
            String name, Model model) {
        model.addAttribute("name", name);
        return "fuck_you";
    }

}
