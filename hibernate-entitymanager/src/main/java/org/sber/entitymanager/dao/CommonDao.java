package org.sber.entitymanager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.sber.entitymanager.entity.Identified;

@RequiredArgsConstructor
public class CommonDao<T extends Identified> {
    private final Class<T> clazz;

    private boolean isNew(T entity) {
        return entity.getId() == null;
    }

    public T save(T entity) {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        if (isNew(entity)) {
            //persist сделает экземпляр entity управляемым
            //можно будет до закрытия транзакции что-нибудь в entity поменять
            //и изменения сохранятся
            entityManager.persist(entity);
        } else {
            //merge не сделает entity управляемым, но он возвращает управляемый обьект
            //которым можно будет пользоваться
            entityManager.merge(entity);
        }
        transaction.commit();
        entityManager.close();
        return entity;
    }

    public T findById(Long id) {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        T t = entityManager.find(clazz, id);
        entityManager.close();
        return t;
    }
}
