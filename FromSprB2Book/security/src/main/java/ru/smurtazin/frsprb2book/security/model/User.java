package ru.smurtazin.frsprb2book.security.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Setter @Getter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
        name="user_role",
        joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
        inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles;
}
