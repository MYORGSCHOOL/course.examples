package org.sber.entitymanager.service;


import org.sber.entitymanager.dto.StudentDto;
import org.sber.entitymanager.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     * Сохранить студента
     * @param studentDto студент
     * @return студент с ид
     */
    StudentDto save(StudentDto studentDto);

    /**
     * Найти студента по ид
     * @param id ид
     * @return студент
     */
    StudentDto findById(Long id);

    /**
     * Найти студентов по имени группы
     * @param name имя группы
     * @return студенты
     */
    List<StudentDto> findByGroup(String name);

    /**
     * Найти студентов через именованый запрос
     * @return студенты
     */
    List<StudentDto> findAllNamedQuery();

    /**
     * Достать студентов с дисциплинами
     * @return студенты
     */
    List<StudentDto> findAllWithDisciplines();

}
