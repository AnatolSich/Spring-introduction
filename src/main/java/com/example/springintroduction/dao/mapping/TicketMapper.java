package com.example.springintroduction.dao.mapping;

import com.example.springintroduction.model.Ticket;
import com.example.springintroduction.model.impl.TicketImpl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketMapper implements RowMapper<Ticket> {

    @Override
    public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TicketImpl(
                rs.getLong("id"),
                rs.getLong("event_id"),
                rs.getLong("user_id"),
                Ticket.Category.valueOf(rs.getString("category")),
                rs.getInt("place")
        );
    }

}
