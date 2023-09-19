package org.sber.session.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnection {
    private static SessionFactory factory;
    private static final String CFG_XML = "hibernate.cfg.xml";

    static {
        try {
            factory = new Configuration().configure(CFG_XML).buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
