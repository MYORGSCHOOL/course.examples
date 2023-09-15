package org.sber;

import org.sber.dao.UserDao;
import org.sber.model.User;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        try {
            List<User> allUsers = userDao.getAllUsers();
            System.out.println(allUsers);
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

}
