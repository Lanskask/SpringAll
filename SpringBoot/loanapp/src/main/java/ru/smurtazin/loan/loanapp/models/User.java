package ru.smurtazin.loan.loanapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_users")
@Setter @Getter
@NoArgsConstructor
public class User {

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    // TODO: i'm not sure it should be Cascade and Fetch
    @Column
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private List<Loan> loans;
}
