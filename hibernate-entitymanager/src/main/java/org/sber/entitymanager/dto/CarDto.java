package org.sber.entitymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ДТО Машина
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
