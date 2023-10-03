package org.mvc.dao;

import org.mvc.model.Car;
import org.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoJdbcTemplate implements UsersDao {

    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDaoJdbcTemplate(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private final String SQL_SELECT_USERS_WITH_CARS = "select " +
            "users.*, car.id as car_id, car.model from users left join " +
            "car on users.id = car.owner_id";
    private final String SQL_SELECT_USERS_BY_FIRST_NAME = "select " +
            "* from users where first_name = ?";
    private final String SQL_BY_ID = "select " +
            "* from users where id = :id";
    private final String SQL_INSERT_USER = "insert into users(first_name, last_name) " +
            "values (:first_name, :last_name)";


    @Override
    public Optional<User> find(long id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<User> query = namedParameterJdbcTemplate.query(SQL_BY_ID, params, userRowMapperWithoutCars);
        if (query.isEmpty()) {
            return Optional.empty();
        }
        if (query.size() > 1) {
            throw new RuntimeException("not 1 row");
        }
        return Optional.of(query.get(0));
    }

    @Override
    public void save(User model) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("first_name", model.getFirstName());
        params.put("last_name", model.getLastName());
        namedParameterJdbcTemplate.update(SQL_INSERT_USER, params);
    }

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_USERS_WITH_CARS, userRowMapperWithCars);
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return template.query(SQL_SELECT_USERS_BY_FIRST_NAME, userRowMapperWithoutCars, firstName);
    }

    private RowMapper<User> userRowMapperWithoutCars = (ResultSet rs, int i) ->
            User.builder()
                    .id(rs.getInt("id"))
                    .firstName(rs.getString("first_name"))
                    .lastName(rs.getString("last_name")).build();

    private RowMapper<User> userRowMapperWithCars = (ResultSet rs, int i) -> {
        Car build = Car.builder().id(rs.getInt("car_id")).model(rs.getString("model")).build();
        return User.builder()
                .id(rs.getInt("id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name")).cars(Collections.singletonList(build)).build();
    };


}
