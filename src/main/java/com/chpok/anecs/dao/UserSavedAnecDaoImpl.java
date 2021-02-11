package com.chpok.anecs.dao;

import com.chpok.anecs.models.Anec;
import com.chpok.anecs.models.UserSavedAnec;
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
public class UserSavedAnecDaoImpl implements UserSavedAnecDao{

    private JdbcTemplate template;
    private boolean flag;

    //language=SQL
    private String SQL_INSERT_USER_SAVED_ANEC = "INSERT INTO chpok_user_saved_anecdot(user_id, anec_id) VALUES(?, ?)";

    //language=SQL
    private String SQL_SELECT_SAVED_ANECS_BY_USER_ID = "SELECT chpok_anecdot.* FROM chpok_anecdot WHERE chpok_anecdot.id IN (SELECT anec_id FROM chpok_user_saved_anecdot WHERE user_id = ?);";

    @Autowired
    public UserSavedAnecDaoImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
        flag = false;
    }

    RowMapper<Anec> rowMapperForAnecText = (resultSet, i) -> {
        return new Anec(resultSet.getLong("id"), resultSet.getString("anecdot_text"));
    };

    public void save(UserSavedAnec userSavedAnec) {
        template.update(SQL_INSERT_USER_SAVED_ANEC, userSavedAnec.getUserId(), userSavedAnec.getAnecId());
    }

    @Override
    public List<Anec> getSavedAnecsByUserId(Long id) throws NullPointerException{
        List<Anec> anecList;
        anecList = template.query(SQL_SELECT_SAVED_ANECS_BY_USER_ID, rowMapperForAnecText, id);

        if (anecList.isEmpty()) {

        }
        return anecList;
    }

    public Optional<UserSavedAnec> get(Long id) {
        return Optional.empty();
    }

    public void update(UserSavedAnec userSavedAnec) {

    }

    public void delete(Long id) {

    }

    public List<UserSavedAnec> getAll() {
        return null;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
