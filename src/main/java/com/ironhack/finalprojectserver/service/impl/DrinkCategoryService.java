package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.DrinkCategoryDTO;
import com.ironhack.finalprojectserver.model.DrinkCategory;
import com.ironhack.finalprojectserver.repository.DrinkCategoryRepository;
import com.ironhack.finalprojectserver.service.interfaces.DrinkCategoryServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DrinkCategoryService implements DrinkCategoryServiceInterface {
    @Autowired
    private DrinkCategoryRepository drinkCategoryRepository;

    public DrinkCategory saveDrinkCategory(DrinkCategoryDTO category) {
        log.info("Saving a new drink category {}", category.getName());
        DrinkCategory drinkCategory = new DrinkCategory();
        drinkCategory.setName(category.getName());
        return drinkCategoryRepository.save(drinkCategory);
    }

    public List<DrinkCategory> getDrinkCategories() {
        log.info("Fetching all drink categories");
        return drinkCategoryRepository.findAll();
    }
}
