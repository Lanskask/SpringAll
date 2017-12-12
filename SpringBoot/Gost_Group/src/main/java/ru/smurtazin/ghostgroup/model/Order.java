package ru.smurtazin.ghostgroup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "client_orders")
public class Order {
    @Id
    @GeneratedValue
//    @JsonView({Department.class, Employee.class})
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name")
//    @JsonView({Department.class, Employee.class})
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
//    @JsonView({Department.class, Employee.class})
    private Date orderDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finish_till")
//    @JsonView({Department.class, Employee.class})
    private Date termEnd;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToOne(cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "order_depart")

    @JoinColumn(name = "depart_id", referencedColumnName = "id")
    @JsonIgnoreProperties("department")
    private Department department;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToOne
//    @JsonManagedReference(value = "order_empl")
    @JsonIgnoreProperties("orders")
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
