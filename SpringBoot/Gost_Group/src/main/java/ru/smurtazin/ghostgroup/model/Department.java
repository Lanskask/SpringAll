package ru.smurtazin.ghostgroup.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "type")
    private String type;
    /*@Enumerated(EnumType.STRING)
    private DepartType type;*/

    @OneToMany
//    @JsonManagedReference(value = "depart_empl")
    @JsonIgnoreProperties("department")
    @JoinColumn(name = "depart_id", referencedColumnName = "id")
    private List<Employee> employees;

    @OneToMany
//    @JsonBackReference(value = "order_depart")
    @JsonIgnoreProperties("department")
    @JoinColumn(name = "depart_id", referencedColumnName = "id")
    private List<Order> orders;

}
