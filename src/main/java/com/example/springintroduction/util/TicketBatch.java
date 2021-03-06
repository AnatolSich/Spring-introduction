package com.example.springintroduction.util;

import com.example.springintroduction.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketBatch {

    private List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return new com.google.gson.Gson().toJson(this);
    }

}
