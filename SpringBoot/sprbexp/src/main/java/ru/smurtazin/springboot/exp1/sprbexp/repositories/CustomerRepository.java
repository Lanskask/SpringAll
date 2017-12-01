package ru.smurtazin.springboot.exp1.sprbexp.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.smurtazin.springboot.exp1.sprbexp.models.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

}
