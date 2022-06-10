package com.ironhack.finalprojectserver.controller;

import com.google.gson.Gson;
import com.ironhack.finalprojectserver.DTO.UserVerifyDTO;
import com.ironhack.finalprojectserver.model.User;
import com.ironhack.finalprojectserver.repository.UserRepository;
import com.ironhack.finalprojectserver.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public String verifyToken(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        UserVerifyDTO userVerifyDTO = new UserVerifyDTO(userFromDb.getId(), userFromDb.getName(), userFromDb.getImage());
        Gson gson = new Gson();
        String userDetails = gson.toJson(userVerifyDTO);
        return userDetails;
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable(name = "id") Long userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
