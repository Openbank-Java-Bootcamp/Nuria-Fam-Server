package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.PlateDTO;
import com.ironhack.finalprojectserver.model.Plate;

import java.util.List;

public interface PlateServiceInterface {
    Plate getPlate(Long id);
    List<Plate> getPlatesByCategory(Long categoryId);
    Plate savePlate(PlateDTO plate);
    void updatePlate(Long id, PlateDTO plate);
    void deletePlate(Long id);
}
