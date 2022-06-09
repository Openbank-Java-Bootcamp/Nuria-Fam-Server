package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.PlateCategoryDTO;
import com.ironhack.finalprojectserver.model.PlateCategory;

public interface PlateCategoryServiceInterface {
    PlateCategory savePlateCategory(PlateCategoryDTO category);
}
