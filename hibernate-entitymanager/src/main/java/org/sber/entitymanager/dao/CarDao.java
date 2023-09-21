package org.sber.entitymanager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.sber.entitymanager.entity.Car;

/**
 * DAO по работе с машинами через EntityManager
 */
public class CarDao {

    /**
     * Создать машину
     * @param car машина
     * @return машина
     */
    public Car create(Car car) {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(car);
        transaction.commit();
        Car saved = entityManager.find(Car.class, car.getId());
        entityManager.close();
        return saved;
    }

}
