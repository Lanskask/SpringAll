package ru.smurtazin.ghostgroup.model;

import lombok.Data;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "depart_id", referencedColumnName = "id")
    private Department department;

}
