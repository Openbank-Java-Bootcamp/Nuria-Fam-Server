package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.model.*;
import com.ironhack.finalprojectserver.repository.*;
import com.ironhack.finalprojectserver.service.interfaces.UserServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User saveUser(User userSignupDTO) {
        log.info("Saving a new user {} inside of the database", userSignupDTO.getName());
        User user = new User(userSignupDTO.getName(), userSignupDTO.getEmail(), userSignupDTO.getPassword(), userSignupDTO.getImage());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        log.info("Fetching user with id {}", id);
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public void updateUser(Long id, User userSignupDTO) {
        log.info("Updating user with id {}", id);
        User user = new User(userSignupDTO.getName(), userSignupDTO.getEmail(), userSignupDTO.getPassword(), userSignupDTO.getImage());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userFromDB = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setId(userFromDB.getId());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        log.info("Deleting restaurant with id {}", id);
        userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User is found in the database: {}", email);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        }
    }
}
