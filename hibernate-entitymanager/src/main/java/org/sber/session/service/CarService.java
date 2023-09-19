package org.sber.session.service;

import org.sber.session.dto.CarDto;

/**
 * Сервис по работе с машнами
 */
public interface CarService {
    /**
     * Создать машину
     * @param car машины
     * @return машина
     */
    CarDto create(CarDto car);
}
