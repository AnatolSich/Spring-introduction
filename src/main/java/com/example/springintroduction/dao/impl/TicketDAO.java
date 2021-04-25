package com.example.springintroduction.dao.impl;

import com.example.springintroduction.dao.CrudRepository;
import com.example.springintroduction.model.Event;
import com.example.springintroduction.model.Ticket;
import com.example.springintroduction.model.User;
import com.example.springintroduction.storage.Storage;
import com.example.springintroduction.storage.StorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TicketDAO implements CrudRepository<Ticket, Long> {

    private Storage<Ticket, Long> storage;
    private StorageUtil<Ticket, Long> storageUtil;

    public void initStorage() {
        storage.patchUpdate(storageUtil.readCSV(StorageUtil.Model.TICKET));
    }

    @Autowired
    public void setStorageUtil(StorageUtil<Ticket, Long> storageUtil) {
        this.storageUtil = storageUtil;
    }

    @Autowired
    public void setStorage(Storage<Ticket, Long> storage) {
        this.storage = storage;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return storage.update(ticket.getId(), ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return storage.update(ticket.getId(), ticket);
    }

    @Override
    public Ticket findOne(Long id) {
        return storage.findOne(id);
    }

    @Override
    public void delete(Long id) {
        storage.delete(id);
    }

    @Override
    public Iterable<Ticket> findAll() {
        return storage.findAll();
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        List<Ticket> ticketList = (List<Ticket>) storage.findAll();
        return ticketList.stream().filter(u -> u.getUserId() == user.getId())
                .skip(pageNum)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        List<Ticket> ticketList = (List<Ticket>) storage.findAll();
        return ticketList.stream().filter(e -> e.getEventId() == event.getId())
                .skip(pageNum)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

}
