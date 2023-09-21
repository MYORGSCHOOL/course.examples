package org.sber.entitymanager.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.sber.entitymanager.dao.DisciplineDao;
import org.sber.entitymanager.dto.DisciplineDto;
import org.sber.entitymanager.entity.Discipline;

public class DisciplineServiceImpl implements DisciplineService {
    DisciplineDao dao = new DisciplineDao();
    private final MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineDto save(DisciplineDto disciplineDto) {
        Discipline object = dao.save(mapperFacade.map(disciplineDto, Discipline.class));
        return mapperFacade.map(object, DisciplineDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DisciplineDto findById(Long id) {
        return mapperFacade.map(dao.findById(id), DisciplineDto.class);
    }
}
