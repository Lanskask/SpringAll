package ru.smurtazin.ghostgroup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smurtazin.ghostgroup.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}