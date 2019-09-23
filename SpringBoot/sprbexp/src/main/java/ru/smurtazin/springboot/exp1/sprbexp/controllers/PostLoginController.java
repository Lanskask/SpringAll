package ru.smurtazin.springboot.exp1.sprbexp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostLoginController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String helloIn(
            @RequestParam(value="name", required=false, defaultValue="World")
                    String name,
            Model model) {
        model.addAttribute("name", name);
        return "hello_in";
    }

}
