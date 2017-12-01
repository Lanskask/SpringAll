package ru.smurtazin.spring.exp1;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Log4j
@Component
public class MemoryStorage implements Storage {
    private List<User> usersList = new ArrayList<>();

    @Override
    public void add(User user) {
        this.usersList.add(user);
        System.out.println("Length of usersList: " + this.usersList.size());
    }
}
