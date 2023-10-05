package ru.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springdata.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
