package org.sber.entitymanager.service;

import org.sber.entitymanager.dto.CarDto;

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
