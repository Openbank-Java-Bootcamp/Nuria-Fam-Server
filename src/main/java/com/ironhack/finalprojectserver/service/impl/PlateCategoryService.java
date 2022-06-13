package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.PlateCategoryDTO;
import com.ironhack.finalprojectserver.model.PlateCategory;
import com.ironhack.finalprojectserver.repository.PlateCategoryRepository;
import com.ironhack.finalprojectserver.repository.RestaurantRepository;
import com.ironhack.finalprojectserver.service.interfaces.PlateCategoryServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlateCategoryService implements PlateCategoryServiceInterface {
    @Autowired
    private PlateCategoryRepository plateCategoryRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public PlateCategory savePlateCategory(PlateCategoryDTO category) {
        log.info("Saving a new plate category {}", category.getName());
        PlateCategory plateCategory = new PlateCategory();
        plateCategory.setName(category.getName());
        plateCategory.setRestaurant(restaurantRepository.findById(category.getRestaurantId()).get());
        return plateCategoryRepository.save(plateCategory);
    }

    public List<PlateCategory> getPlateCategories(Long id) {
        log.info("Fetching all plate categories");
        return plateCategoryRepository.findAllByRestaurant(id);
    }
}
