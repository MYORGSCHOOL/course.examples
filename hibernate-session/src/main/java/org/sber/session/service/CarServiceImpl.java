package org.sber.session.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.sber.session.dao.CarDao;
import org.sber.session.dto.CarDto;
import org.sber.session.entity.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    private final CarDao dao = new CarDao();

    // Для того чтобы руками не мапить ентити на дто
    private final MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CarDto> getAllCars() {
        List<Car> allCars = dao.getAllCars();
        List<CarDto> carDtos = mapperFacade.mapAsList(allCars, CarDto.class);
        for (CarDto carDto: carDtos) {
            //расширение дто в сервисе (добавление какой-то логики)
            carDto.setDescription("");
        }
        return carDtos;
    }
}
