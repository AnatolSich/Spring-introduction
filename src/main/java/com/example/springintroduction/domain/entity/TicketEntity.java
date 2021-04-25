package com.example.springintroduction.domain.entity;


import com.example.springintroduction.domain.interfaces.Ticket;
import com.example.springintroduction.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


//@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity implements Ticket {

    private long id;
    private Category category;
    private int place;
    EventEntity eventEntity;
    UserEntity userEntity;

    @Override
    public void setId(long id) throws IdNotFoundException {
        if (id <= 0) {
            throw new IdNotFoundException(String.format("Id %s is invalid", id));
        } else this.id = id;
    }

    @Override
    public long getEventId() {
        return eventEntity.getId();
    }

    @Override
    public void setEventId(long eventId) throws IdNotFoundException {
        eventEntity.setId(eventId);
    }

    @Override
    public long getUserId() {
        return userEntity.getId();
    }

    @Override
    public void setUserId(long userId) throws IdNotFoundException {
        userEntity.setId(userId);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = Category.valueOf(category);
    }

}
