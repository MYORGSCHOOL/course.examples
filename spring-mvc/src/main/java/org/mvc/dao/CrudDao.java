package org.mvc.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T> {
    /**
     * Найти по ид
     * @param id ид
     * @return обьект
     */
    Optional<T> find(long id);

    /**
     * Сохранить модель
     * @param model обьект
     */
    void save(T model);

    /**
     * Найти все
     * @return список обьектов
     */
    List<T> findAll();
}
