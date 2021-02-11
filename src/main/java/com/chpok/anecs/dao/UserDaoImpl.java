package com.chpok.anecs.dao;

import com.chpok.anecs.models.Anec;
import com.chpok.anecs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao{
    private JdbcTemplate template;

    //language=SQL
    private String SQL_SELECT_USER_BY_USERNAME = "SELECT * FROM chpok_user WHERE username = ?";

    //language=SQL
    private String SQL_SELECT_USER_BY_ID = "SELECT * FROM chpok_user WHERE id = ?";

    //language=SQL
    private String SQL_SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM chpok_user WHERE (username = ?) AND (password = ?)";

    //language=SQL
    private String SQL_INSERT_USER = "INSERT INTO chpok_user(username, password) VALUES (?, ?)";

    RowMapper<User> rowMapper = (resultSet, i) -> {
        return new User(resultSet.getLong("id"), resultSet.getString("username"), resultSet.getString("password"));
    };

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Anec> getFavAnecListFromUser() {
        return null;
    }

    @Override
    public boolean checkIfUserExist(String username, String password) {
        List<User> userList =
                template.query(SQL_SELECT_USER_BY_USERNAME_AND_PASSWORD, rowMapper, username, password);
        return !userList.isEmpty();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        List<User> userList = template.query(SQL_SELECT_USER_BY_USERNAME, rowMapper, username);

        if (userList.isEmpty())
            return Optional.empty();
        return Optional.of(userList.get(0));
    }

    @Override
    public void save(User user) {
        template.update(SQL_INSERT_USER, user.getUsername(), user.getPassword());
    }

    @Override
    public Optional<User> get(Long id) {
        List<User> userList = template.query(SQL_SELECT_USER_BY_ID, rowMapper, id);
        if (userList.isEmpty())
            return Optional.empty();
        return Optional.of(userList.get(0));
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
