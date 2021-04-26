package com.example.springintroduction.dao.mapping;

import com.example.springintroduction.model.impl.UserAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UseAccountMapper implements RowMapper<UserAccount> {

    @Override
    public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserAccount(
                rs.getLong("user_id"),
                rs.getDouble("score")
        );
    }

}
