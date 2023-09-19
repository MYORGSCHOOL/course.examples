package org.sber.session;

import org.sber.session.dto.CarDto;
import org.sber.session.entity.Car;
import org.sber.session.service.CarService;
import org.sber.session.service.CarServiceImpl;

import java.util.List;

/**
 * Пример работы через Session (Hibernate)
 */
public class Main {
    private static CarService carService = new CarServiceImpl();

    public static void main(String[] args) {
        CarDto honda = carService.createRecord(new CarDto("HONDA"));
        System.out.println(honda);
    }
    
}
