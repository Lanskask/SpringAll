package ru.smurtazin.ghostgroup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.smurtazin.ghostgroup.model.Order;

import javax.persistence.NamedQuery;
import java.util.Date;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Iterable<Order> findByTermEndGreaterThan(Date date);

    @Query(value = "select o from Order o where o.department is not null group by o.department")
    Iterable<Order> getSortByDepertments();

}