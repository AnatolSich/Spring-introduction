package com.example.springintroduction.dao.impl;

import com.example.springintroduction.dao.CrudRepository;
import com.example.springintroduction.model.Event;
import com.example.springintroduction.storage.Storage;
import com.example.springintroduction.storage.StorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventDAO implements CrudRepository<Event, Long> {

    private Storage<Event, Long> storage;
    private StorageUtil<Event, Long> storageUtil;

    @PostConstruct
    public void initStorage() {
        storage.patchUpdate(storageUtil.readCSV(StorageUtil.Model.EVENT));
    }

    @Autowired
    public void setStorageUtil(StorageUtil<Event, Long> storageUtil) {
        this.storageUtil = storageUtil;
    }

    @Autowired
    public void setStorage(Storage<Event, Long> storage) {
        this.storage = storage;
    }

    @Override
    public Event save(Event event) {
        return storage.update(event.getId(), event);
    }

    @Override
    public Event update(Event event) {
        return storage.update(event.getId(), event);
    }

    @Override
    public Event findOne(Long id) {
        return storage.findOne(id);
    }

    @Override
    public void delete(Long id) {
        storage.delete(id);
    }

    @Override
    public Iterable<Event> findAll() {
        return storage.findAll();
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        List<Event> eventList = (List<Event>) storage.findAll();
        return eventList.stream().filter(event -> event.getTitle().equals(title))
                .skip(pageNum)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        List<Event> eventList = (List<Event>) storage.findAll();
        return eventList.stream().filter(event -> event.getDate().equals(day))
                .skip(pageNum)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

}
