package ru.smurtazin.sprbook.repoexp.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.smurtazin.sprbook.repoexp.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
