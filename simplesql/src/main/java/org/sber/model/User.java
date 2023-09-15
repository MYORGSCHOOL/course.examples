package org.sber.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    /**
     * Идентификатор
     */
    private int id;
    /**
     * Имя
     */
    private String name;
    /**
     * Фамилия
     */
    private String surname;
}
