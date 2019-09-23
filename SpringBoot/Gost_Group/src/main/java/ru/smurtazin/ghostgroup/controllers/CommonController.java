package ru.smurtazin.ghostgroup.controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smurtazin.ghostgroup.exceptions.ResourceNotFoundException;

import javax.validation.Valid;

public class CommonController<T> {

    private CrudRepository<T, Integer> repository;

    public void setRepository(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }

    @ResponseBody
    @GetMapping("")
    public Iterable<T> getAllItems() {
        return repository.findAll();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public T geiItem(@PathVariable("id") Integer id) {
        return (T) repository.findOne(id);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<T> createItem(@RequestBody @Valid T item, BindingResult result) {
        if(result.hasErrors())
            return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
        T savedItem = repository.save(item);
        return new ResponseEntity<T>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public T updateItem(@PathVariable("id") Integer id, @RequestBody T item) {
        if(repository.findOne(id).equals(null))
            throw new ResourceNotFoundException("Item with id " + id + " not found");
        return repository.save(item);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public void deleteItem(@PathVariable("id") Integer id) {
        T item = repository.findOne(id);
//        if (item.equals(null)) {
        if (item == null) {
            throw new ResourceNotFoundException("Item with id " + id + " not found.");
        } else {
            repository.delete(item);
        }
    }
}
