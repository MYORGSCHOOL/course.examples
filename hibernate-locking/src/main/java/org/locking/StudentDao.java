package org.locking;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import jakarta.persistence.OptimisticLockException;
import org.locking.entity.Student;
import org.locking.entity.StudentWithVersion;

/**
 * ДАО по работе со студентами
 */
public class StudentDao {
    public Student save(Student entity) {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
        return entity;
    }

    public StudentWithVersion save(StudentWithVersion entity) {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
        return entity;
    }

    /**
     * Найти всех студентов через именованный запрос
     *
     * @return студенты
     */
    public Student twoPessimisticWrite() {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        EntityManager entityManager2 = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction2 = entityManager2.getTransaction();

        transaction.begin();
        Student student = entityManager.find(Student.class, 1L, LockModeType.PESSIMISTIC_WRITE);
        student.setSum(30);

        transaction2.begin();

        Student student2 = entityManager2.find(Student.class, 1L, LockModeType.PESSIMISTIC_WRITE);
        //student2.setSum(20);

        transaction2.commit();
        transaction.commit();

        entityManager.close();
        entityManager2.close();
        return student2;
    }


    public Student twoPessimisticRead() {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        EntityManager entityManager2 = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction2 = entityManager2.getTransaction();

        transaction.begin();
        Student student = entityManager.find(Student.class, 1L, LockModeType.PESSIMISTIC_READ);

        transaction2.begin();

        Student student2 = entityManager2.find(Student.class, 1L, LockModeType.PESSIMISTIC_READ);

        transaction2.commit();
        transaction.commit();

        entityManager.close();
        entityManager2.close();
        return student2;
    }


    public Student twoPessimisticWriteAndRead() {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        EntityManager entityManager2 = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction2 = entityManager2.getTransaction();

        transaction.begin();
        Student student = entityManager.find(Student.class, 1L, LockModeType.PESSIMISTIC_WRITE);
        student.setSum(40);

        transaction2.begin();

        Student student2 = entityManager2.find(Student.class, 1L, LockModeType.PESSIMISTIC_READ);

        transaction2.commit();
        transaction.commit();

        entityManager.close();
        entityManager2.close();
        return student2;
    }

    public void twoOptimistic() {
        EntityManager entityManager = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        EntityManager entityManager2 = DatabaseConnection.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction2 = entityManager2.getTransaction();

        transaction.begin();
        StudentWithVersion student = entityManager.find(StudentWithVersion.class, 1L);
        student.setSum(30);

        transaction2.begin();

        StudentWithVersion student2 = entityManager2.find(StudentWithVersion.class, 1L);
        student2.setSum(20);
        transaction2.commit();
        transaction.commit();

        entityManager.close();
        entityManager2.close();

    }

}
