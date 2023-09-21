package org.sber.entitymanager.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = "contact", name = "uk_contact"))
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "select s from Student s"),
        @NamedQuery(name = "Student.findAllWithAllData", query = "select s from Student s left join fetch s.disciplines d left join fetch s.group g inner join fetch s.contact c"),
        @NamedQuery(name = "Student.findAllByDisciplineId", query = "select s from Student s left join fetch s.group g inner join fetch s.contact c left join fetch s.disciplines d where s.id = :id"),
         // join fetch - от проблемы  n + 1 запрос
})
@AllArgsConstructor

public class Student implements Identified {
    //пустой конструктор нужен хиберу
    public Student() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_discipline",
            joinColumns = {@JoinColumn(name = "student")},
            inverseJoinColumns = {@JoinColumn(name = "discipline")})
    private Set<Discipline> disciplines;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"group\"")
    private Group group;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact", nullable = false)
    private ContactInfo contact;

    @Override
    public Long getId() {
        return id;
    }
}
