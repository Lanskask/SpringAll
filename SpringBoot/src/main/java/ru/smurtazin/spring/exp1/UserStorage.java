package ru.smurtazin.spring.exp1;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserStorage {
    @Getter
    private final Storage storage;

    @Autowired
    public UserStorage(Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }
}
