package ru.smurtazin.TryJdbcConnect.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private static final long serialVersionUID = 1L;

    long custId;
    String name;
    int age;
}
