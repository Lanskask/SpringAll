package ru.smurtazin.ghostgroup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smurtazin.ghostgroup.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}