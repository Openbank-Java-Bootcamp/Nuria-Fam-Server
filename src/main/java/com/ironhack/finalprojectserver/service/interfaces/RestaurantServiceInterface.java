package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.RestaurantDTO;
import com.ironhack.finalprojectserver.model.Restaurant;

import java.util.List;

public interface RestaurantServiceInterface {
    Restaurant getRestaurant(Long id);
    List<Restaurant> getAllRestaurants();
    List<Restaurant> getRestaurantsByUserId(Long userId);
    Restaurant saveRestaurant(RestaurantDTO restaurant);
    void updateRestaurant(Long id, RestaurantDTO restaurant);
    void deleteRestaurant(Long id);
}
