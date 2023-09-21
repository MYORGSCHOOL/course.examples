package org.sber.entitymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ДТО Группы
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    /**
     * Идентификатор
     */
    private Long id;
    /**
     * Имя
     */
    private String name;

}
