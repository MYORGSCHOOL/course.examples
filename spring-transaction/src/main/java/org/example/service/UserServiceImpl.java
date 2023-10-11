package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.User;
import org.example.exception.CheckedException;
import org.example.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UsersRepository usersRepository;
    private final UserServiceImpl2 userServiceImpl2;

    @Transactional
    public void saveCheckedException() throws CheckedException {
        User user = User.builder()
                .firstName("1")
                .lastName("1").
                build();
        usersRepository.save(user);
        throw new CheckedException();
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveCheckedExceptionWithRollbackFor() throws CheckedException {
        User user = User.builder()
                .firstName("2")
                .lastName("2").
                build();
        usersRepository.save(user);
        throw new CheckedException();
    }

    @Transactional
    public void saveRuntimeException() {
        User user = User.builder()
                .firstName("3")
                .lastName("3").
                build();
        usersRepository.save(user);
        throw new RuntimeException();
    }

    @Transactional
    public void saveTwoTransactionRuntime() {
        User user = User.builder()
                .firstName("4")
                .lastName("4").
                build();
        usersRepository.save(user);
        userServiceImpl2.saveUser();
    }

    @Transactional
    public void saveTwoTransactionRuntimeCatch() {
        User user = User.builder()
                .firstName("6")
                .lastName("6").
                build();
        usersRepository.save(user);
        try {
            userServiceImpl2.saveUser2();
        } catch (RuntimeException e) {

        }
    }
}

@Service
@RequiredArgsConstructor
class UserServiceImpl2 {

    private final UsersRepository usersRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveUser() {
        User user = User.builder()
                .firstName("5")
                .lastName("5").
                build();
        usersRepository.save(user);
        throw new RuntimeException();

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveUser2() {
        User user = User.builder()
                .firstName("7")
                .lastName("7").
                build();
        usersRepository.save(user);
        throw new RuntimeException();
    }

}
