package ru.smurtazin.ghostgroup.model;

import lombok.Data;

import javax.persistence.*;

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
}
