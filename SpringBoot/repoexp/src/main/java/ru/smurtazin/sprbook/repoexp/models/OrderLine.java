package ru.smurtazin.sprbook.repoexp.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "order_lines")
public class OrderLine {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
