package ru.smurtazin.ghostgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smurtazin.ghostgroup.model.Order;
import ru.smurtazin.ghostgroup.repositories.OrderRepository;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(path = "/orders")
public class OrderController extends CommonController<Order> {

    @Autowired
    private OrderRepository repository;

    @PostConstruct
    public void init() {
        super.setRepository((JpaRepository) repository);
    }

}
