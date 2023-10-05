package ru.springdata.service;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springdata.entity.Car;
import ru.springdata.model.User;
import ru.springdata.repository.CarRepository;
import ru.springdata.repository.UsersRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Lazy
@Scope("prototype")
public class UserServiceImpl implements UserService {


    private final UsersRepository usersRepository;
    private final CarRepository carRepository;
    // Для того чтобы руками не мапить ентити на дто
    private final MapperFacade mapperFacade = new DefaultMapperFactory
            .Builder()
            .build()
            .getMapperFacade();

    @Override
    public List<User> findAll() {
        List<ru.springdata.entity.User> users = usersRepository.findAll();
        return mapperFacade.mapAsList(users, User.class);
    }

    @Override
    @Transactional
    public void save(User user) {
        ru.springdata.entity.User entity = mapperFacade.map(user, ru.springdata.entity.User.class);
        ru.springdata.entity.User user1 = usersRepository.save(entity);
        Car audi = Car.builder().owner(user1).model("AUDI").build();
        carRepository.save(audi);
    }
}
