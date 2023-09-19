package org.sber.dto;

import lombok.Data;

/**
 * ДТО Машина
 */
@Data
public class CarDto {
    /**
     * Идентификатор
     */
    private Integer id;
    /**
     * Модель
     */
    private String model;
    /**
     * Описание
     */
    private String description;
}
