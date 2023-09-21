package org.sber.entitymanager.service;


import org.sber.entitymanager.dto.DisciplineDto;

/**
 * Сервис по работе с дисциплинами
 */
public interface DisciplineService {
    /**
     * Сохранить
     * @param disciplineDto дисциплина
     * @return дисциплина сохраненная
     */
    DisciplineDto save(DisciplineDto disciplineDto);

    /**
     * Найти по ид
     * @param id ид
     * @return дисциплина
     */
    DisciplineDto findById(Long id);
}
