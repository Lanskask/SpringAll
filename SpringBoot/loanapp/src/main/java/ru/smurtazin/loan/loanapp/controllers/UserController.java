package ru.smurtazin.loan.loanapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smurtazin.loan.loanapp.exceptions.ResourceNotFoundException;
import ru.smurtazin.loan.loanapp.models.Loan;
import ru.smurtazin.loan.loanapp.models.User;
import ru.smurtazin.loan.loanapp.repositories.LoanRepository;
import ru.smurtazin.loan.loanapp.repositories.UserRepository;

import javax.validation.Valid;
import java.sql.Date;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public @ResponseBody Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return this.userRepository.findOne(id);
    }

    /*@ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping("")
    public User createUser(@RequestBody @Valid User user, BindingResult bResult) {
        if(bResult.hasErrors())
            throw new ResourceNotFoundException("User is not valid");
        return userRepository.save(user);
    }*/

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user, BindingResult bResult) {
        if(bResult.hasErrors())
            return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);

        User savedUser = userRepository.save(user);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyRespHead1", "Val1");
        responseHeaders.set("MyRespHead2", "Val2");
        return new ResponseEntity<>(savedUser, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody User updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        if(userRepository.findOne(id).equals(null))
            throw new ResourceNotFoundException("User with id:" + id + " not found.");
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        User user = userRepository.findOne(id);
        if(user.equals(null))
            throw new ResourceNotFoundException("User with id:" + id + " not found.");
        else userRepository.delete(user.getId());
    }
}
