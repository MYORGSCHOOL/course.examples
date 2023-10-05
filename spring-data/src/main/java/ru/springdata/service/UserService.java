package ru.springdata.service;

import ru.springdata.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void save(User user);
}
