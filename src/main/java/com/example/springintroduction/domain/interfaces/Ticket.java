package com.example.springintroduction.domain.interfaces;


import com.example.springintroduction.exceptions.IdNotFoundException;

public interface Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}

    /**
     * Ticket Id. UNIQUE.
     * @return Ticket Id.
     */
    long getId();
    void setId(long id) throws IdNotFoundException;
    long getEventId();
    void setEventId(long eventId) throws IdNotFoundException;
    long getUserId();
    void setUserId(long userId) throws IdNotFoundException;
    Category getCategory();
    void setCategory(String category);
    int getPlace();
    void setPlace(int place);

}
