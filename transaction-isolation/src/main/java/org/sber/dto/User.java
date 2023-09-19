package org.sber.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private String surName;
    /**
     * Адрес
     */
    private String address;
}
