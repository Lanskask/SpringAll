package ru.smurtazin.loan.loanapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_users")
@Setter @Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

//    @Column
    // TODO: i'm not sure it should be Cascade and Fetch
    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private List<Loan> loans;*/
}
