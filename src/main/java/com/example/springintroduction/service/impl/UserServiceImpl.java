package com.example.springintroduction.service.impl;

import com.example.springintroduction.dao.impl.UserDAO;
import com.example.springintroduction.model.User;
import com.example.springintroduction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUserById(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDAO.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.update(user);
    }

    @Override
    public void deleteUser(long userId) {
        userDAO.delete(userId);
    }

}
