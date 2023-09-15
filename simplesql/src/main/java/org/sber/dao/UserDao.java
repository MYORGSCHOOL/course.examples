package org.sber.dao;

import org.sber.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO по работе с юзерами
 */
public class UserDao {

    public static final String SELECT_FROM_USERS = "select * from users";

    /**
     * Получить список всех пользователей
     *
     * @return список пользователей
     * @throws SQLException
     */
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_USERS);
            while (resultSet.next()) {
                users.add(User.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .build());
            }
        }
        return users;
    }

}
