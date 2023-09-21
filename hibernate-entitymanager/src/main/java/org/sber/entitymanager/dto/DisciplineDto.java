package org.sber.entitymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ДТО Дисциплина
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineDto {
    /**
     * Идентификатор
     */
    private Long id;

    /**
     * Код
     */
    private String code;

    /**
     * Описание
     */
    private String descr;
}
