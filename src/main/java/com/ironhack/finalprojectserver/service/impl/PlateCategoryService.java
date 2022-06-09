package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.PlateCategoryDTO;
import com.ironhack.finalprojectserver.model.PlateCategory;
import com.ironhack.finalprojectserver.repository.PlateCategoryRepository;
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

    public PlateCategory savePlateCategory(PlateCategoryDTO category) {
        log.info("Saving a new plate category {}", category.getName());
        PlateCategory plateCategory = new PlateCategory();
        plateCategory.setName(category.getName());
        return plateCategoryRepository.save(plateCategory);
    }

    public List<PlateCategory> getPlateCategories() {
        log.info("Fetching all plate categories");
        return plateCategoryRepository.findAll();
    }
}
