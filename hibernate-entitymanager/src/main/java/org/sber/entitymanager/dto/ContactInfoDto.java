package org.sber.entitymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ДТО Контактов
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoDto {
    /**
     * Идентификатор
     */
    private Long id;
    /**
     * Мейл
     */
    private String email;
}
