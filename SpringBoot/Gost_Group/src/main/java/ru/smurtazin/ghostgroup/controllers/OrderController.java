package ru.smurtazin.ghostgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.smurtazin.ghostgroup.exceptions.ResourceNotFoundException;
import ru.smurtazin.ghostgroup.model.Order;
import ru.smurtazin.ghostgroup.repositories.OrderRepository;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping(path = "/orders")
public class OrderController extends CommonController<Order> {

    @Autowired
    private OrderRepository repository;

    @PostConstruct
    public void init() {
        super.setRepository((JpaRepository) repository);
    }

    @Override
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<Order> createItem(@RequestBody @Valid Order item, BindingResult result) {
        if(result.hasErrors())
            return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
        if(item.getDepartment() == null && item.getEmployee() == null)
            return new ResponseEntity<>(item, HttpStatus.BAD_REQUEST);
        Order savedItem = repository.save(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @ResponseBody
    @GetMapping("/incomplete")
    public Iterable<Order> getIncompleteItems() {
        return repository.findByTermEndGreaterThan(new Date());
    }

    @ResponseBody
    @GetMapping("/{id}/time_to_finish")
    public String getOrderTimeTo(@PathVariable("id") Integer id) {
        Long difference = repository.findOne(id).getTermEnd().getTime()
                - new Date().getTime();
        return this.diffInDaysAndHours(difference);
    }

    String diffInDaysAndHours(Long difference) {
        Long lengthOfHour = new Long(1000 * 60 * 60);
        Long days = (difference / lengthOfHour) / 24;
        Long hours = (difference / lengthOfHour) % 24;
        return "This order should be finished in " +
                days + " days and "
                + hours + " hours";
    }

}
