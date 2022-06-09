package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.DrinkCategoryDTO;
import com.ironhack.finalprojectserver.service.interfaces.DrinkCategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DrinkCategoryController {
    @Autowired
    private DrinkCategoryServiceInterface drinkCategoryService;

    @PostMapping("/drinkcategory")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDrinkCategory(@RequestBody @Valid DrinkCategoryDTO category) {
        drinkCategoryService.saveDrinkCategory(category);
    }
}
