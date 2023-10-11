package org.example;

import org.example.config.JPAConfig;
import org.example.exception.CheckedException;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        /**
         * Сохранение сущности внутри транзакции
         * с выкидыванием checked exception во время исполнения метода
         * Транзакция не откатится, произойдет коммит, сущность остается в бд
         */
        try {

            userService.saveCheckedException();
        } catch (CheckedException e) {
            System.out.println("Checked exception caught!");
        }

        /**
         * Сохранение сущности внутри транзакции
         * с выкидыванием checked exception во время исполнения метода
         * Дополнительно стоит условие отката транзакции на определенное исключение
         * @Transactional(rollbackFor = Exception.class)
         * Транзакция откатится, в бд ничего не сохранится
         */
        try {
            userService.saveCheckedExceptionWithRollbackFor();
        } catch (CheckedException e) {
            System.out.println("Checked exception caught!");
        }


        /**
         * Сохранение сущности внутри транзакции
         * с выкидыванием runtime exception во время исполнения метода
         * Транзакция откатится, в бд ничего не сохранится
         */
        try {
            userService.saveRuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Runtime exception caught!");
        }

        /**
         * Сохранение двух сущностей - одна транзакция внутри другой
         * с выкидыванием runtime exception во время исполнения внутреннего метода
         * Транзакции откатится, в бд ничего не сохранится
         */

        try {
            userService.saveTwoTransactionRuntime();
        } catch (RuntimeException e) {
            System.out.println("Runtime exception caught!");
        }

        /**
         * Сохранение двух сущностей - одна транзакция внутри другой
         * с выкидыванием runtime exception во время исполнения внутреннего метода
         * и отлавливанем этого исключения во внешнем
         * Внутренняя транзакция откатится, внешняя закоммитится
         */

        try {
            userService.saveTwoTransactionRuntimeCatch();
        } catch (RuntimeException e) {
            System.out.println("Runtime exception caught!");
        }

    }
}
