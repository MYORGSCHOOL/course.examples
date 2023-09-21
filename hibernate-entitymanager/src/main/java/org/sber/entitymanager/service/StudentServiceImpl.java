package org.sber.entitymanager.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.sber.entitymanager.dao.StudentDao;
import org.sber.entitymanager.dto.StudentDto;
import org.sber.entitymanager.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDao();
    private final MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentDao.save(mapperFacade.map(studentDto, Student.class));
        return mapperFacade.map(student, StudentDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StudentDto findById(Long id) {
        return mapperFacade.map(studentDao.findById(id), StudentDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<StudentDto> findByGroup(String name) {
        return mapperFacade.mapAsList(studentDao.findByGroup(name), StudentDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<StudentDto> findAllNamedQuery() {
        return mapperFacade.mapAsList(studentDao.findAllNamedQuery(), StudentDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<StudentDto> findAllWithDisciplines() {
        return mapperFacade.mapAsList(studentDao.findAll(), StudentDto.class);
    }

}
