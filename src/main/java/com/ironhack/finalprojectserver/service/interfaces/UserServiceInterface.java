package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);
    User getUser(Long id);
    List<User> getUsers();
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}