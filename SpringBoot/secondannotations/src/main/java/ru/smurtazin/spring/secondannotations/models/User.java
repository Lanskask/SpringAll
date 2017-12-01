package ru.smurtazin.spring.secondannotations.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter @Setter @ToString
public class User {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

}
