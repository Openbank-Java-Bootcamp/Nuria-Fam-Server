package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.PlateCategoryDTO;
import com.ironhack.finalprojectserver.model.PlateCategory;

import java.util.List;

public interface PlateCategoryServiceInterface {
    PlateCategory savePlateCategory(PlateCategoryDTO category);
    List<PlateCategory> getPlateCategories(Long id);
}
