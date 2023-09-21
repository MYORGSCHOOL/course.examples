package org.sber.entitymanager.dao;

import org.sber.entitymanager.entity.Discipline;

/**
 * ДАО по работе с дисциплинами
 */
public class DisciplineDao extends CommonDao<Discipline> {
    public DisciplineDao() {
        super(Discipline.class);
    }
}
