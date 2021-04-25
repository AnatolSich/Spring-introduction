package com.example.springintroduction.domain.entity;



import com.example.springintroduction.domain.interfaces.Event;
import com.example.springintroduction.exceptions.IdNotFoundException;
import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventEntity implements Event {

    private long id;
    private String title;
    private Date date;

    @Override
    public void setId(long id) throws IdNotFoundException {
        if ( id <= 0 ) {
            throw new IdNotFoundException(String.format("Id %s is invalid", id));
        } else this.id = id;
    }
}
