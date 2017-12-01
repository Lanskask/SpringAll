package ru.smurtazin.sprbook.repoexp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.smurtazin.sprbook.repoexp.repositories.CustomerRepository;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String getCustomers(Model model) {
//        model.addAllAttributes();
        model.addAttribute("customers", this.customerRepository.findAll());
        return "customers";
    }

}
