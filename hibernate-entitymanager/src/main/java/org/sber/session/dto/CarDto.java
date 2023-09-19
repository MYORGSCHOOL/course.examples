package org.sber.session.dto;

import lombok.Data;

/**
 * ДТО Машина
 */
@Data
public class CarDto {
    public CarDto(String model) {
        this.model = model;
    }

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
