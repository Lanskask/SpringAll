package ru.smurtazin.ghostgroup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smurtazin.ghostgroup.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}