package org.sber.session.service;

import org.sber.session.dto.CarDto;

import java.util.List;

/**
 * Сервис по работе с машнами
 */
public interface CarService {

    /**
     * Получить список машин
     * @return список машин
     */
    List<CarDto> getAllCars();
}
