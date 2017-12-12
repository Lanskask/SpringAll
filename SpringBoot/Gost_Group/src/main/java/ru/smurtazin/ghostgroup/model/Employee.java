package ru.smurtazin.ghostgroup.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @OneToOne/*(cascade = CascadeType.ALL, fetch = FetchType.EAGER)*/
//    @JsonBackReference(value = "depart_empl")
    @JsonIgnoreProperties("employee")
    @JoinColumn(name = "depart_id", referencedColumnName = "id")
    private Department department;

    @OneToMany
    @JsonIgnoreProperties("employee")
//    @JsonBackReference(value = "order_empl")
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private List<Order> orders;

}
