package org.sber.session.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.sber.session.dao.CarDao;
import org.sber.session.dto.CarDto;
import org.sber.session.entity.Car;

public class CarServiceImpl implements CarService {
    private final CarDao dao = new CarDao();

    // Для того чтобы руками не мапить ентити на дто
    private final MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    @Override
    public CarDto create(CarDto car) {
        Car createdCar = dao.create(mapperFacade.map(car, Car.class));
        return mapperFacade.map(createdCar, CarDto.class);
    }
}
