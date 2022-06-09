package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.DrinkCategoryDTO;
import com.ironhack.finalprojectserver.model.DrinkCategory;

public interface DrinkCategoryServiceInterface {
    DrinkCategory saveDrinkCategory(DrinkCategoryDTO category);
}
