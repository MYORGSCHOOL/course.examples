package org.sber.service;

import org.sber.dto.CarDto;

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

    /**
     * Вставка машины без коммита
     */
    void insertCarWithoutCommit();

    /**
     * Вставка машины с коммитом
     */
    void insertCarWithCommit();

    /**
     * Вывести суммы идшников
     */
    void printSumIdWithParallelInsertion();

    /**
     * Вывести все машины с параллельной вставкой
     */
    void printAllCarsWithInsertion();
}
