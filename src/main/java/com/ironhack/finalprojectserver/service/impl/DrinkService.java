package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.DrinkDTO;
import com.ironhack.finalprojectserver.model.Drink;
import com.ironhack.finalprojectserver.repository.DrinkCategoryRepository;
import com.ironhack.finalprojectserver.repository.DrinkRepository;
import com.ironhack.finalprojectserver.repository.RestaurantRepository;
import com.ironhack.finalprojectserver.service.interfaces.DrinkServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DrinkService implements DrinkServiceInterface {
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private DrinkCategoryRepository drinkCategoryRepository;

    public Drink getDrink(Long id) {
        log.info("Fetching drink with id {}", id);
        return drinkRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Drink not found"));
    }

    public List<Drink> getDrinksByCategory(Long categoryId) {
        log.info("Fetching drink by category");
        return drinkRepository.findByCategory(categoryId);
    }

    public Drink saveDrink(DrinkDTO drink) {
        log.info("Saving a new drink");
        Drink newDrink = new Drink();
        newDrink.setName(drink.getName());
        newDrink.setInformation(drink.getInformation());
        newDrink.setPrice(drink.getPrice());
        newDrink.setRestaurant(restaurantRepository.findById(drink.getRestaurantId()).get());
        newDrink.setCategory(drinkCategoryRepository.findById(drink.getCategory()).get());
        if (newDrink.getId() != null) {
            Optional<Drink> drinkFromDB = drinkRepository.findById(newDrink.getId());
            if (drinkFromDB.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Drink with id " + newDrink.getId() + " already exist");
        }
        return drinkRepository.save(newDrink);
    }

    public void updateDrink(Long id, DrinkDTO drink) {
        log.info("Updating drink with id {}", id);
        Drink newDrink = new Drink();
        newDrink.setName(drink.getName());
        newDrink.setInformation(drink.getInformation());
        newDrink.setPrice(drink.getPrice());
        newDrink.setRestaurant(restaurantRepository.findById(drink.getRestaurantId()).get());
        newDrink.setCategory(drinkCategoryRepository.findById(drink.getCategory()).get());
        Drink drinkFromDB = drinkRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Drink not found"));
        newDrink.setId(drinkFromDB.getId());
        drinkRepository.save(newDrink);
    }

    public void deleteDrink(Long id) {
        log.info("Deleting drink with id {}", id);
        drinkRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        if (drinkRepository.findById(id).isPresent()) {
            drinkRepository.deleteById(id);
        }
    }
}
