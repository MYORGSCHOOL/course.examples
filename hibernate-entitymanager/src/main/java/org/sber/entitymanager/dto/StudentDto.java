package org.sber.entitymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * ДТО Студент
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    /**
     * Идентификатор
     */
    private Long id;
    /**
     * Имя
     */
    private String name;
    /**
     * Дисциплины
     */
    private Set<DisciplineDto> disciplines;

    /**
     * Группа
     */
    private GroupDto group;

    /**
     * Контакт
     */
    private ContactInfoDto contact;
}
