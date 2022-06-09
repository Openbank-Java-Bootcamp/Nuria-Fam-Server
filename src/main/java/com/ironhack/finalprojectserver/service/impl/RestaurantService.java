package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.RestaurantDTO;
import com.ironhack.finalprojectserver.model.Restaurant;
import com.ironhack.finalprojectserver.repository.RestaurantRepository;
import com.ironhack.finalprojectserver.repository.UserRepository;
import com.ironhack.finalprojectserver.service.interfaces.RestaurantServiceInterface;
import com.ironhack.finalprojectserver.utils.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RestaurantService implements RestaurantServiceInterface {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    public Restaurant getRestaurant(Long id) {
        log.info("Fetching restaurant with id {}", id);
        return restaurantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));
    }

    public List<Restaurant> getAllRestaurants() {
        log.info("Fetching all restaurant");
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getRestaurantsByUserId(Long userId) {
        log.info("Fetching restaurants by user id");
        return restaurantRepository.findRestaurantsByUserId(userId);
    }

    public Restaurant saveRestaurant(RestaurantDTO restaurant) {
        log.info("Saving a new restaurant");
        Address address = new Address(restaurant.getStreet(), restaurant.getCity(), restaurant.getCountry(), restaurant.getPostalCode());
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setPhone(restaurant.getPhone());
        newRestaurant.setAddress(address);
        newRestaurant.setUser(userRepository.findById(restaurant.getUserId()).get());
        if (newRestaurant.getId() != null) {
            Optional<Restaurant> restaurantFromDB = restaurantRepository.findById(newRestaurant.getId());
            if (restaurantFromDB.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Restaurant with id " + newRestaurant.getId() + " already exist");
        }
        return restaurantRepository.save(newRestaurant);
    }

    public void updateRestaurant(Long id, RestaurantDTO restaurant) {
        log.info("Updating restaurant with id {}", id);
        Address address = new Address(restaurant.getStreet(), restaurant.getCity(), restaurant.getCountry(), restaurant.getPostalCode());
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setPhone(restaurant.getPhone());
        newRestaurant.setAddress(address);
        newRestaurant.setUser(userRepository.findById(restaurant.getUserId()).get());
        Restaurant restaurantFromDB = restaurantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));
        newRestaurant.setId(restaurantFromDB.getId());
        restaurantRepository.save(newRestaurant);
    }

    public void deleteRestaurant(Long id) {
        log.info("Deleting restaurant with id {}", id);
        restaurantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        if (restaurantRepository.findById(id).isPresent()) {
            restaurantRepository.deleteById(id);
        }
    }
}
