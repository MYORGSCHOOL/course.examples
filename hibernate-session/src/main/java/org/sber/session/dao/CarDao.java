package org.sber.session.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.sber.session.entity.Car;

import java.util.List;

/**
 * DAO по работе с машинами через Hibernate Session
 */
public class CarDao {

    /**
     * Получить список машин
     *
     * @return список машин
     */
    public List<Car> getAllCars() {
        Session session = DatabaseConnection.getFactory().openSession();
        List<Car> cars = session.createQuery("FROM Car", Car.class).list();
        session.close();
        return cars;
    }

    public Car createRecord(Car car) {
        Session session = DatabaseConnection.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(car);
        transaction.commit();
        Car loaded = session.load(Car.class, id);
        session.close();
        return loaded;
    }

    public Car findById(Integer id) {
        Session session = DatabaseConnection.getFactory().openSession();
        Car car = session.get(Car.class, id);
        session.get(Car.class, id);
        session.close();
        return car;
    }


    public Car updateRecord(Car car) {
        Session session = DatabaseConnection.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Car loaded = session.load(Car.class, car);
        loaded.setModel(car.getModel());
        transaction.commit();
        session.close();
        return loaded;
    }

    public void deleteRecord(Integer id) {
        Session session = DatabaseConnection.getFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Car loaded = session.load(Car.class, id);
        session.delete(loaded);
        transaction.commit();
        session.close();
    }
}
