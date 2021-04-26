package com.example.springintroduction.dao.mapping;

import com.example.springintroduction.model.Event;
import com.example.springintroduction.model.impl.EventImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EventImpl(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getDate("date"),
                rs.getDouble("price")
        );
    }

}
