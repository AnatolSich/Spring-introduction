package com.example.springintroduction.service.impl;

import com.example.springintroduction.dao.impl.EventDAO;
import com.example.springintroduction.model.Event;
import com.example.springintroduction.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;

    @Override
    public Event getEventById(long id) {
        return eventDAO.findOne(id);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDAO.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDAO.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventDAO.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDAO.update(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventDAO.delete(eventId);
    }

}
