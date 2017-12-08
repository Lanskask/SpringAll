package ru.smurtazin.loan.loanapp.controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smurtazin.loan.loanapp.exceptions.ResourceNotFoundException;

import javax.validation.Valid;

public class CommonController<T> {

    private CrudRepository<T, Integer> thisRepository;

    public void setThisRepository(CrudRepository<T, Integer> thisRepository) {
        this.thisRepository = thisRepository;
    }

    @ResponseBody
    @GetMapping("")
    public Iterable<T> getAllItems() {
        return thisRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public T geiItem(@PathVariable("id") Integer id) {
        return (T) thisRepository.findOne(id);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<T> createItem(@RequestBody @Valid T item, BindingResult result) {
        if(result.hasErrors())
            return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
        T savedItem = thisRepository.save(item);
        return new ResponseEntity<T>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public T updateItem(@PathVariable("id") Integer id, @RequestBody T item) {
        if(thisRepository.findOne(id).equals(null))
            throw new ResourceNotFoundException("Item with id " + id + " not found");
        return thisRepository.save(item);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteItem(@PathVariable("id") Integer id) {
        T item = thisRepository.findOne(id);
        if(item.equals(null))
            throw new ResourceNotFoundException("Item with id " + id + " not found.");
        else thisRepository.delete(item);
    }

}
