package ru.smurtazin.ghostgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smurtazin.ghostgroup.model.Department;
import ru.smurtazin.ghostgroup.model.Employee;
import ru.smurtazin.ghostgroup.repositories.EmployeeRepository;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController extends CommonController<Employee> {

    @Autowired
    private EmployeeRepository repository;

    @PostConstruct
    public void init() {
        super.setRepository((JpaRepository) repository);
    }
}
