package org.sber.entitymanager.dao;


import org.sber.entitymanager.entity.Group;

/**
 * Дао по работе с группами
 */
public class GroupDao extends CommonDao<Group> {
    public GroupDao() {
        super(Group.class);
    }
}
