package ru.smurtazin.sprbook.repoexp.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "customer_since")
    private Date customerSince;

}
