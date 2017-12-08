package ru.smurtazin.ghostgroup.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "client_orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finish_till")
    private Date termEnd;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToOne
    @JoinColumn(name = "depart_id", referencedColumnName = "id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
