package com.example.springintroduction.controller;

import com.example.springintroduction.facade.BookingFacade;
import com.example.springintroduction.model.Event;
import com.example.springintroduction.model.Ticket;
import com.example.springintroduction.model.User;
import com.example.springintroduction.model.impl.EventImpl;
import com.example.springintroduction.model.impl.TicketImpl;
import com.example.springintroduction.model.impl.UserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
public class BookingResource extends ParameterizableViewController {

    private Logger log = LoggerFactory.getLogger(BookingResource.class);

    @Autowired
    private BookingFacade bookingFacade;

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody UserImpl user) {
        log.info("User created - " + user);
        bookingFacade.createUser(user);
        return user;
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public Event addEvent(@RequestBody EventImpl event) {
        log.info("Event created - " + event);
        bookingFacade.createEvent(event);
        return event;
    }

    @RequestMapping(value = "/ticket/book", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public Ticket addEvent(@RequestBody TicketImpl ticket) {
        log.info("Ticket booked" + ticket);
        bookingFacade.bookTicket(ticket.getUserId(), ticket.getEventId(), ticket.getPlace(), ticket.getCategory());
        return ticket;
    }

    @RequestMapping(value = "ticket/batch", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file) throws IOException, ParserConfigurationException, SAXException {
        log.info("file name - " + file.getOriginalFilename());
        bookingFacade.saveTicketsFromFile(file.getBytes());
        return "{\"status\" : \"OK\"}";
    }

}
