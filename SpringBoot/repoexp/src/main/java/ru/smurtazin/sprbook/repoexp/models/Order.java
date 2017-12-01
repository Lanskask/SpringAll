package ru.smurtazin.sprbook.repoexp.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "order_line", referencedColumnName = "id")
    private OrderLine orderLine;

}
