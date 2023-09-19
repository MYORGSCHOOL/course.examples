package org.sber;

import org.sber.dto.CarDto;
import org.sber.service.CarService;
import org.sber.service.CarServiceImpl;

import java.util.List;

/**
 * Пример работы через Session (Hibernate)
 */
public class Main {
    private static CarService carService = new CarServiceImpl();

    public static void main(String[] args) {

//        change hibernate.connection.isolation 1 (READ UNCOMMITTED)

        //       readUncommitted();

//        change hibernate.connection.isolation 2 (READ COMMITTED)

        //      readCommitted();

//        change hibernate.connection.isolation 4 (REPEATABLE READ)


        //      repeatableRead();

//        change hibernate.connection.isolation 8 (SERIALIZABLE)


        //        serializable();
    }

    private static void serializable() {
        carService.printSumIdWithParallelInsertion();
    }

    private static void repeatableRead() {
        carService.printAllCarsWithInsertion();
    }

    private static void readCommitted() {
        carService.insertCarWithoutCommit();
        List<CarDto> carDtos = carService.getAllCars(); //нет грязного чтения
        System.out.println(carDtos);
        carService.printAllCarsWithInsertion(); //можно в одной транзакции прочитать закомиченные изменения другой
    }

    private static void readUncommitted() {
        carService.insertCarWithoutCommit();
        List<CarDto> carDtos = carService.getAllCars();
        System.out.println(carDtos);
    }

}
