package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.DrinkDTO;
import com.ironhack.finalprojectserver.model.Drink;

import java.util.List;

public interface DrinkServiceInterface {
    Drink getDrink(Long id);
    List<Drink> getDrinksByCategory(Long categoryId);
    Drink saveDrink(DrinkDTO drink);
    void updateDrink(Long id, DrinkDTO drink);
    void deleteDrink(Long id);
}
