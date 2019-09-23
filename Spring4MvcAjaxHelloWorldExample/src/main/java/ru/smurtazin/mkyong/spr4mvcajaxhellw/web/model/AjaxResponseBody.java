package ru.smurtazin.mkyong.spr4mvcajaxhellw.web.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import ru.smurtazin.mkyong.spr4mvcajaxhellw.web.jsonview.Views;

@Getter @Setter
public class AjaxResponseBody {

    @JsonView(Views.Public.class)
    String msg;

    @JsonView(Views.Public.class)
    String code;

    @JsonView(Views.Public.class)
    List<User> result;
}
