package ru.smurtazin.loan.loanapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.smurtazin.loan.loanapp.models.User;
import ru.smurtazin.loan.loanapp.repositories.UserRepository;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping(path = "/users")
public class UserController extends CommonController<User> {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        super.setRepository(userRepository);
    }
}
