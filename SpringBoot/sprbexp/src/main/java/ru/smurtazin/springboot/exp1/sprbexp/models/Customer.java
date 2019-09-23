package ru.smurtazin.springboot.exp1.sprbexp.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="customer")
@Setter @Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
