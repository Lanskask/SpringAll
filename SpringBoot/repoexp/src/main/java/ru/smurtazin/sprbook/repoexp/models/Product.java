package ru.smurtazin.sprbook.repoexp.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "in_stock")
    private Boolean inStock;

    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Comment comment;
}
