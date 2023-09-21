package org.sber.entitymanager.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.sber.entitymanager.dao.GroupDao;
import org.sber.entitymanager.entity.Group;

public class GroupServiceImpl implements GroupService {
    GroupDao dao = new GroupDao();

    private final MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    /**
     * {@inheritDoc}
     */
    @Override
    public org.sber.entitymanager.dto.GroupDto save(org.sber.entitymanager.dto.GroupDto groupDto) {
        Group saved = dao.save(mapperFacade.map(groupDto, Group.class));
        return mapperFacade.map(saved, org.sber.entitymanager.dto.GroupDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public org.sber.entitymanager.dto.GroupDto findById(Long id) {
        return mapperFacade.map(dao.findById(id), org.sber.entitymanager.dto.GroupDto.class);
    }
}
