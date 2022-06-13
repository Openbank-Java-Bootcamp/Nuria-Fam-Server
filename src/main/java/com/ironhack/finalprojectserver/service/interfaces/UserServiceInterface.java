package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.UserDTO;
import com.ironhack.finalprojectserver.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(UserDTO userSignupDTO);
    User getUser(Long id);
    List<User> getUsers();
    void updateUser(Long id, UserDTO user);
    void deleteUser(Long id);
}