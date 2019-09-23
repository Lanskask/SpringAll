package ru.smurtazin.springboot.exp1.sprbexp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.smurtazin.springboot.exp1.sprbexp.models.Greeting;

import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingThymeController {

    @GetMapping("greeting_form")
    public String greetingForm(Model model) {
        List<String> strList = Arrays.asList("asd", "asdas", "asf");

        model.addAttribute("greeting", new Greeting());
        model.addAttribute("list_of_strings", strList );
        return "greeting_form";
    }

    @PostMapping("greeting_form")
    public String greetingSubmit(@ModelAttribute Greeting greeting/*,
                                 @ModelAttribute List<String> strList*/) {
        return "result";
    }

}
