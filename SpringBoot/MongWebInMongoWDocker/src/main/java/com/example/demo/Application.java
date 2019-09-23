package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {
    // @RequestMapping("/")
    // public String home() {
    //     return "Hello Docker World";
    // }

		@Autowired
    private PersonRepository repository;

    @RequestMapping("/persons")
    public List<Person> getPersons(){
        return repository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
