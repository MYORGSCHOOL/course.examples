package org.sber.session.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private String surName;
}
