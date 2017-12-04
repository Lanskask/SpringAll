package ru.smurtazin.justsomeexperiments.pakTest;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SomeObjBuilder {

    Man man;

    public SomeObjBuilder(Man man) {
        this.man = man;
    }

    SomeObjBuilder enhanceMan(Man man) {
        this.man = man;
        return this;
    }

    Man getResultMan() {
        return this.man;
    }

    SomeObjBuilder setManName(String name) {
        this.man.setName(name);
        return this;
    }
    SomeObjBuilder setManSurName(String surName) {
        this.man.setSurName(surName);
        return this;
    }
    SomeObjBuilder setAge(Integer age) {
        this.man.setAge(age);
        return this;
    }
    SomeObjBuilder setIsMale(Boolean isMale) {
        this.man.setIsMale(isMale);
        return this;
    }

}
