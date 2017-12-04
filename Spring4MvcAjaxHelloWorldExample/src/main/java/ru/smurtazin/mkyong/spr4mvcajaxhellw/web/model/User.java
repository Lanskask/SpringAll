package ru.smurtazin.mkyong.spr4mvcajaxhellw.web.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.smurtazin.mkyong.spr4mvcajaxhellw.web.jsonview.Views;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {

    @JsonView(Views.Public.class)
    String username;

    String password;

    @JsonView(Views.Public.class)
    String email;

    @JsonView(Views.Public.class)
    String phone;

    String address;
}