package com.example.springintroduction.dao.mapping;

import com.example.springintroduction.model.User;
import com.example.springintroduction.model.impl.UserImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserImpl(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
        );
    }

}
