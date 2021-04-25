package com.example.springintroduction.domain.interfaces;


import com.example.springintroduction.exceptions.IdNotFoundException;

import java.util.Date;

public interface Event {
    /**
     * Event id. UNIQUE.
     * @return Event Id
     */
    long getId();
    void setId(long id) throws IdNotFoundException;
    String getTitle();
    void setTitle(String title);
    Date getDate();
    void setDate(Date date);
}
