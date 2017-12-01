package ru.smurtazin.loan.loanapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_loans")
@Setter @Getter
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "amount")
    private Long amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "term_end")
    private Date termEnd;

//    @Column
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /*// TODO: delete this
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;*/

}
