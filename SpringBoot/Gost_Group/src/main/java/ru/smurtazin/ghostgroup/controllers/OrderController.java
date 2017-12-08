package ru.smurtazin.ghostgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.smurtazin.ghostgroup.repositories.OrderRepository;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
}
