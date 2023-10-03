package org.mvc.dao;

import org.mvc.model.User;

import java.util.List;

/**
 * ДАО для юзеров
 */
public interface UsersDao extends CrudDao<User> {
    /**
     * Найти всех юзеров по имени
     * @param firstName имя
     * @return юзеры
     */
    List<User> findAllByFirstName(String firstName);
}
