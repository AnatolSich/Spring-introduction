package com.example.springintroduction.domain.entity;


import com.example.springintroduction.domain.interfaces.User;
import com.example.springintroduction.exceptions.EmailNotFoundException;
import com.example.springintroduction.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

//@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements User {

    private long id;
    private String name;
    private String email;


    @Override
    public void setId(long id) throws IdNotFoundException {
        if (id <= 0) {
            throw new IdNotFoundException(String.format("Id %s is invalid", id));
        } else this.id = id;
    }

    @Override
    public void setEmail(String email) throws EmailNotFoundException {
            if (email.equals("") || email.isEmpty())  {
                throw new EmailNotFoundException(String.format("Email %s is invalid!", id));
        } else this.email = email;
    }
}
