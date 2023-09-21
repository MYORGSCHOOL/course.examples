package org.sber.entitymanager.service;


import org.sber.entitymanager.dto.GroupDto;

public interface GroupService {
    /**
     * Сохранить группу
     * @param groupDto группа
     * @return группа
     */
    GroupDto save(GroupDto groupDto);

    /**
     * Найти по ид
     * @param id ид
     * @return группа
     */
    GroupDto findById(Long id);
}
