package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.DrinkDTO;
import com.ironhack.finalprojectserver.model.Drink;
import com.ironhack.finalprojectserver.service.interfaces.DrinkServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DrinkController {
    @Autowired
    private DrinkServiceInterface drinkService;

    @GetMapping("/drinks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Drink getDrink(@PathVariable(name = "id") Long id) {
        return drinkService.getDrink(id);
    }

    @GetMapping("/drinks/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Drink> getDrinkByCategory(@PathVariable(name = "id") Long id) {
        return drinkService.getDrinksByCategory(id);
    }

    @PostMapping("/drinks")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDrink(@RequestBody @Valid DrinkDTO drink) {
        drinkService.saveDrink(drink);
    }

    @PutMapping("/drinks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDrink(@PathVariable Long id, @RequestBody @Valid DrinkDTO drink) {
        drinkService.updateDrink(id, drink);
    }

    @DeleteMapping("/drinks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDrink(@PathVariable Long id) {
        drinkService.deleteDrink(id);
    }
}
