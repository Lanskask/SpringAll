package ru.smurtazin.frsprb2book.security.simplewebtry1.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class User {

    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @Email(message="{invalid.email}")
    @NotNull
    private String email;

    @NotNull
    @Size(min = 6, max = 50)
    private String password;

}
