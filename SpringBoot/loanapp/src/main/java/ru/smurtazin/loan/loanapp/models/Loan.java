package ru.smurtazin.loan.loanapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_loans")
@JsonIgnoreProperties("user")
@Setter @Getter
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Integer id;

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
