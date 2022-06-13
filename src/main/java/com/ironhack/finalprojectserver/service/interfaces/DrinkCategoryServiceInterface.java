package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.DrinkCategoryDTO;
import com.ironhack.finalprojectserver.model.DrinkCategory;

import java.util.List;

public interface DrinkCategoryServiceInterface {
    DrinkCategory saveDrinkCategory(DrinkCategoryDTO category);
    List<DrinkCategory> getDrinkCategories(Long id);
}
