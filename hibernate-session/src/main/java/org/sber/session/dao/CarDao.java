package org.sber.session.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sber.session.entity.Car;

import java.util.List;

/**
 * DAO по работе с машинами
 */
public class CarDao {

    public static final String CFG_XML = "hibernate.cfg.xml";

    /**
     * Получить список машин
     * @return список машин
     */
    public List<Car> getAllCars() {
        SessionFactory factory;
        try {
            factory = new Configuration().configure(CFG_XML).buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
        Session session = factory.openSession();
        return session.createQuery("FROM Car", Car.class).list();
    }
}
