package ru.springdata.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {
    /**
     * Имя
     */
    private String firstName;
    /**
     * Фамилия
     */
    private String lastName;

    /**
     * Машины
     */
    private List<Car> cars;
}
