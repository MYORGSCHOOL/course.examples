package org.sber.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.sber.entity.Car;

import java.util.List;

/**
 * DAO по работе с машинами
 */
public class CarDao {

    public List<Car> getAllCarsWithoutTransaction() {
        Session session = DatabaseConnection.getConnection().openSession();
        return session.createQuery("FROM Car", Car.class).list();
    }

    public void insertCarWithoutCommit() {
        Session session = DatabaseConnection.getConnection().openSession();
        Car car = new Car();
        car.setModel("NIVA");
        session.beginTransaction();
        session.persist(car);
        session.flush();

    }
    public void insertCarWithCommit() {
        Session session = DatabaseConnection.getConnection().openSession();
        Car car = new Car();
        car.setModel("NIVA");
        Transaction transaction = session.beginTransaction();
        session.persist(car);
        session.flush();
        transaction.commit();
    }

    public void printSumIdWithParallelInsertion() {
        Session session = DatabaseConnection.getConnection().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(session.createQuery("select sum(id) from Car where model = 'NIVA'", Integer.class).uniqueResult());

        Car car = new Car();
        car.setModel("NIVA");

        Session session2 = DatabaseConnection.getConnection().openSession();
        Transaction transaction2 = session2.beginTransaction();

        session.persist(car);
        session.flush();

        System.out.println(session2.createQuery("select sum(id) from Car where model = 'NIVA'", Integer.class).uniqueResult());
        transaction2.commit();
    }

    public void printAllCarsWithInsertion() {
        Session session = DatabaseConnection.getConnection().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(session.createQuery("FROM Car", Car.class).list());
        insertCarWithCommit();
        System.out.println(session.createQuery("FROM Car", Car.class).list());
        transaction.commit();
    }
}
