package com.example.springintroduction.service.impl;

import com.example.springintroduction.dao.impl.TicketDAO;
import com.example.springintroduction.model.Event;
import com.example.springintroduction.model.Ticket;
import com.example.springintroduction.model.User;
import com.example.springintroduction.model.impl.TicketImpl;
import com.example.springintroduction.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO ticketDAO;

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketDAO.save(new TicketImpl(new Date().getTime(), eventId, userId, category, place));
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
       return ticketDAO.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDAO.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public void cancelTicket(long ticketId) {
        ticketDAO.delete(ticketId);
    }

}
