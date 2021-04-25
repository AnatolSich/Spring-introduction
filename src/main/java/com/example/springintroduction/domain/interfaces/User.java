package com.example.springintroduction.domain.interfaces;

import com.example.springintroduction.exceptions.EmailNotFoundException;
import com.example.springintroduction.exceptions.IdNotFoundException;

public interface User {
    /**
     * User Id. UNIQUE.
     * @return User Id.
     */
    long getId();
    void setId(long id) throws IdNotFoundException;
    String getName();
    void setName(String name);

    /**
     * User email. UNIQUE.
     * @return User email.
     */
    String getEmail();
    void setEmail(String email) throws EmailNotFoundException;
}
