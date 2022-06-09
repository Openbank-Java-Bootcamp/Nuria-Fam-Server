package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.RestaurantDTO;
import com.ironhack.finalprojectserver.model.*;
import com.ironhack.finalprojectserver.service.interfaces.RestaurantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {
    @Autowired
    private RestaurantServiceInterface restaurantService;

    @GetMapping("/restaurants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant getRestaurant(@PathVariable(name = "id") Long restaurantId) {
        return restaurantService.getRestaurant(restaurantId);
    }

    @GetMapping("/restaurants")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> getRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurants/userid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> getRestaurantByUserId(@PathVariable(name = "id") Long userId) {
        return restaurantService.getRestaurantsByUserId(userId);
    }

    @PostMapping("/restaurants")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRestaurant(@RequestBody @Valid RestaurantDTO restaurant) {
        restaurantService.saveRestaurant(restaurant);
    }

    @PutMapping("/restaurants/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRestaurant(@PathVariable Long id, @RequestBody @Valid RestaurantDTO restaurant) {
        restaurantService.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }
}
