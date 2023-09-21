package org.sber.entitymanager;

import org.sber.entitymanager.dto.CarDto;
import org.sber.entitymanager.dto.ContactInfoDto;
import org.sber.entitymanager.dto.DisciplineDto;
import org.sber.entitymanager.dto.GroupDto;
import org.sber.entitymanager.dto.StudentDto;
import org.sber.entitymanager.service.CarService;
import org.sber.entitymanager.service.CarServiceImpl;
import org.sber.entitymanager.service.DisciplineService;
import org.sber.entitymanager.service.DisciplineServiceImpl;
import org.sber.entitymanager.service.GroupService;
import org.sber.entitymanager.service.GroupServiceImpl;
import org.sber.entitymanager.service.StudentService;
import org.sber.entitymanager.service.StudentServiceImpl;

import java.util.HashSet;
import java.util.List;

/**
 * Пример работы через Session (Hibernate)
 */
public class Main {
    private static final CarService carService = new CarServiceImpl();
    private static final GroupService groupService = new GroupServiceImpl();
    private static final DisciplineService disciplineService = new DisciplineServiceImpl();
    private static final StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {

        CarDto honda = carService.create(CarDto.builder().model("HONDA").build());
        System.out.println(honda);

        //Если не хотим перед тем как добавить
        //студента сохранять сначала его группы, потом дисциплины,и т д,
        // то можно во всех связках добавить  cascade = CascadeType.ALL
        // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        // после этого можно сохранить абсолютно новый обьект студента с заполненными
        // новыми дисциплинами, контактами, группами


        GroupDto group = GroupDto.builder().name("ABC").build();
        group = groupService.save(group);
        StudentDto vasya = StudentDto.builder().name("vasya")
                .group(group)
                .contact(ContactInfoDto.builder().email("email").build())
                .build();
        studentService.save(vasya);
        StudentDto petya = StudentDto.builder().name("petya")
                .group(group)
                .contact(ContactInfoDto.builder().email("email").build())
                .build();
        studentService.save(petya);
        DisciplineDto math = DisciplineDto.builder()
                .code("123")
                .descr("Math")
                .build();
        DisciplineDto philo = DisciplineDto.builder()
                .code("1234")
                .descr("philo")
                .build();
        DisciplineDto sport = DisciplineDto.builder()
                .code("12345")
                .descr("sport")
                .build();
        math = disciplineService.save(math);
        philo = disciplineService.save(philo);
        sport = disciplineService.save(sport);
        petya.setDisciplines(new HashSet<>(List.of(math, philo, sport)));
        studentService.save(petya);
        // этот метод отработает хорошо так как через join fetch подхватит все связные сущности
        List<StudentDto> studentList = studentService.findAllWithDisciplines();
        for (StudentDto s : studentList) {
            System.out.println(s.getDisciplines());
        }

        //!!! Строка ниже вызовет org.hibernate.LazyInitializationException
        // (маппер при маппинге ентити на дто будет использовать геттеры и сеттеры)
        // так как сессия уже будет закрыта, получение через геттеры связок с FetchType.LAZY приведет к исключению

        //List<StudentDto> studentDtos = studentService.findAllNamedQuery();
    }
    
}
