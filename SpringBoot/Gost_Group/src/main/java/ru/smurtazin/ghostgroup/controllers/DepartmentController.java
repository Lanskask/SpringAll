package ru.smurtazin.ghostgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smurtazin.ghostgroup.model.Department;
import ru.smurtazin.ghostgroup.repositories.DepartmentRepository;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController extends CommonController<Department> {

    @Autowired
    private DepartmentRepository repository;

    @PostConstruct
    public void init() {
        super.setRepository((JpaRepository) repository);
    }
}
