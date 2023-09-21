package org.sber.entitymanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Entity
@Data
@Table(name = "\"group\"")
public class Group implements Identified {
    //пустой конструктор нужен хиберу
    public Group() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private Set<Student> students = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }
}
