package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.PlateCategoryDTO;
import com.ironhack.finalprojectserver.model.PlateCategory;
import com.ironhack.finalprojectserver.service.interfaces.PlateCategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlateCategoryController {
    @Autowired
    private PlateCategoryServiceInterface plateCategoryService;

    @PostMapping("/platecategory")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlateCategory(@RequestBody @Valid PlateCategoryDTO category) {
        plateCategoryService.savePlateCategory(category);
    }

    @GetMapping("/platecategory")
    @ResponseStatus(HttpStatus.OK)
    public List<PlateCategory> getPlateCategory() {
        return plateCategoryService.getPlateCategories();
    }
}
