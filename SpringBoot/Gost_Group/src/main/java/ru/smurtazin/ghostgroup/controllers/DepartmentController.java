package ru.smurtazin.ghostgroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.smurtazin.ghostgroup.repositories.DepartmentRepository;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
}
