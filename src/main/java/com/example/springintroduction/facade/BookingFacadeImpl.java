package com.example.springintroduction.facade;

import com.example.springintroduction.model.Event;
import com.example.springintroduction.model.Ticket;
import com.example.springintroduction.model.User;
import com.example.springintroduction.service.EventService;
import com.example.springintroduction.service.TicketService;
import com.example.springintroduction.service.UserAccountService;
import com.example.springintroduction.service.UserService;
import com.example.springintroduction.util.TicketBatch;
import com.example.springintroduction.util.XMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Component
public class BookingFacadeImpl implements BookingFacade {

    @Value("${ticket.booking}")
    private String xmlFileName;

    private UserService userService;
    private EventService eventService;
    private TicketService ticketService;
    private UserAccountService userAccountService;
    private XMLConverter xmlConverter;
    private JmsTemplate jmsTemplate;


    @Autowired
    public BookingFacadeImpl(UserService userService,
                             EventService eventService,
                             TicketService ticketService,
                             UserAccountService userAccountService,
                             XMLConverter xmlConverter,
                             JmsTemplate jmsTemplate) {
        this.userService = userService;
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.userAccountService = userAccountService;
        this.xmlConverter = xmlConverter;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public Event getEventById(long id) {
        return eventService.getEventById(id);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventService.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long id) {
        return userService.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        userService.createUser(user);
        userAccountService.openAccount(user.getId());
        return user;
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public void deleteUser(long userId) {
        userService.deleteUser(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public void cancelTicket(long ticketId) {
        ticketService.cancelTicket(ticketId);
    }

    @Override
    public void refillAccount(long userID, double money) {
        userAccountService.refillAccount(userID, money);
    }

    @Override
    public void withdrawAccount(long userID, double money) {
        userAccountService.withdrawAccount(userID, money);
    }


    @Override
    public double getScore(long userId) {
        return userAccountService.getScore(userId);
    }

    @Override
    public void saveTicketsFromFile() {
        TicketBatch tickets = (TicketBatch) xmlConverter.convertFromXMLToObject(xmlFileName);
        ticketService.saveAllTickets(tickets.getTickets());
    }

    @Override
    public void saveTicketsFromFile(byte[] stream) {
        InputStream inputStream = new ByteArrayInputStream(stream);
        TicketBatch tickets = (TicketBatch) xmlConverter.convertFromXMLToObject(inputStream);
        ticketService.saveAllTickets(tickets.getTickets());
    }

    @Override
    public void bookTicketAsync(Ticket ticket) {
        jmsTemplate.convertAndSend("ticket-receiver", ticket);
    }

}
