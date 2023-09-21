package org.sber.entitymanager.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.sber.entitymanager.dao.CarDao;
import org.sber.entitymanager.dto.CarDto;
import org.sber.entitymanager.entity.Car;

public class CarServiceImpl implements CarService {
    private final CarDao dao = new CarDao();

    // Для того чтобы руками не мапить ентити на дто
    private final MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    /**
     * {@inheritDoc}
     */
    @Override
    public CarDto create(CarDto car) {
        Car createdCar = dao.create(mapperFacade.map(car, Car.class));
        return mapperFacade.map(createdCar, CarDto.class);
    }
}
