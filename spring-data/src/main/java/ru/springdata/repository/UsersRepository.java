package ru.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springdata.entity.User;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByLastNameAndFirstName(String lastName, String firstName);
}
