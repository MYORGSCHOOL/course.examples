package org.sber.session.service;

import org.sber.session.dto.CarDto;

import java.util.List;
import java.util.Optional;

/**
 * Сервис по работе с машнами
 */
public interface CarService {

    /**
     * Получить список машин
     *
     * @return список машин
     */
    List<CarDto> getAllCars();

    /**
     * Создать запись
     * @param car машина
     * @return машина
     */
    CarDto createRecord(CarDto car);

    /**
     * Поиск по идентификатору
     * @param id идентификатор
     * @return машина
     */
    Optional<CarDto> findById(Integer id);

    /**
     * Обновить машину
     * @param car машина
     * @return обновленная машина
     */
    CarDto updateRecord(CarDto car);

    /**
     * Удалить запись по ид
     * @param id идентификатов
     */
    void deleteRecord(Integer id);
}
