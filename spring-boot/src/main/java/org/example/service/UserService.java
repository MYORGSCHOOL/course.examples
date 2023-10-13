package org.example.service;

import org.example.entity.UserEntity;
import org.example.model.User;
import org.example.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User getUser() {
        Optional<UserEntity> id = usersRepository.findById(1L);
        if (id.isPresent()) {
            return User.builder().name(id.get().getFirstName()).build();
        }
        return User.builder().name("default").build();
    }
}
