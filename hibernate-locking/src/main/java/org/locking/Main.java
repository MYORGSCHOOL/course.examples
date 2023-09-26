package org.locking;

import org.locking.entity.Student;
import org.locking.entity.StudentWithVersion;

public class Main {
    /**
     * Пессимистическая блокировка использует механизм блокировки, предоставляемый базовой базой данных,
     * для блокировки существующих записей в таблицах. JPA необходимо знать, как активировать
     * эти блокировки, а некоторые базы данных их не поддерживают или поддерживают лишь частично.
     *
     * Для Postgres:
     *
     * Key Share - беру блокировку строки, но мне нужны только ее ключевые поля, остальное можно изменять
     * Share - нужно прочитать строку, но при этом нельзя допустить, чтобы она как-либо изменилась другой транзакцией
     * No Key Update - буду изменять только те поля, которые не входят в уникальные индексы (внешние ключи трогать не буду)
     * Update - Возьму и полностью изменю всю строку или удалю
     */


    /**
     * Оптимистическая блокировка полностью контролируется JPA
     * и требует только дополнительного столбца версии в таблицах БД.
     * Она полностью независим от базового механизма БД
     */


    static StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {
        /**
         * Примеры пессимистической
         */

        studentDao.save(Student.builder().sum(2).build());
        // studentDao.twoPessimisticWrite();
        // studentDao.twoPessimisticWriteAndRead();
        // studentDao.twoPessimisticRead();

        /**
         * Примеры оптимистической
         */
        studentDao.save(StudentWithVersion.builder().sum(2).build());
        studentDao.twoOptimistic();
    }
}
