package org.sber.entitymanager.dao;


import jakarta.persistence.EntityManager;
import org.sber.entitymanager.entity.Student;

import java.util.List;

/**
 * ДАО по работе со студентами
 */
public class StudentDao extends CommonDao<Student> {

    public StudentDao() {
        super(Student.class);
    }

    public List<Student> findByGroup(String name) {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        List<Student> students = entityManager.createQuery("select s from Student s inner join fetch s.contact c left join fetch s.disciplines d join s.group g where g.name = :group_name", Student.class)
                .setParameter("group_name", name).getResultList();
        entityManager.close();
        return students;
    }

    /**
     * Найти всех студентов через именованный запрос
     * @return студенты
     */
    public List<Student> findAllNamedQuery() {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        List<Student> students = entityManager.createNamedQuery("Student.findAll", Student.class).getResultList();
        entityManager.close();
        return students;
    }

    /**
     * Достать всех студентов с дисциплинами
     * @return студенты
     */
    public List<Student> findAll() {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        List<Student> resultList = entityManager.createNamedQuery("Student.findAllWithAllData", Student.class)
                .getResultList();
        entityManager.close();
        return resultList;
    }

}
