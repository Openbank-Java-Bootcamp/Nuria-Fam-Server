package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.PlateDTO;
import com.ironhack.finalprojectserver.model.Plate;
import com.ironhack.finalprojectserver.model.Restaurant;
import com.ironhack.finalprojectserver.repository.PlateCategoryRepository;
import com.ironhack.finalprojectserver.repository.PlateRepository;
import com.ironhack.finalprojectserver.repository.RestaurantRepository;
import com.ironhack.finalprojectserver.service.interfaces.PlateServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlateService implements PlateServiceInterface {
    @Autowired
    private PlateRepository plateRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private PlateCategoryRepository plateCategoryRepository;

    public Plate getPlate(Long id) {
        log.info("Fetching plate with id {}", id);
        return plateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plate not found"));
    }

    public List<Plate> getPlatesByCategory(Long categoryId) {
        log.info("Fetching plate by category");
        return plateRepository.findByCategory(categoryId);
    }

    public Plate savePlate(PlateDTO plate) {
        log.info("Saving a new plate");
        Plate newPlate = new Plate();
        newPlate.setName(plate.getName());
        newPlate.setIngredients(plate.getIngredients());
        newPlate.setPrice(plate.getPrice());
        newPlate.setRestaurant(restaurantRepository.findById(plate.getRestaurantId()).get());
        newPlate.setCategory(plateCategoryRepository.findById(plate.getCategory()).get());
        if (newPlate.getId() != null) {
            Optional<Plate> plateFromDB = plateRepository.findById(newPlate.getId());
            if (plateFromDB.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Plate with id " + newPlate.getId() + " already exist");
        }
        return plateRepository.save(newPlate);
    }

    public void updatePlate(Long id, PlateDTO plate) {
        log.info("Updating plate with id {}", id);
        Plate newPlate = new Plate();
        newPlate.setName(plate.getName());
        newPlate.setIngredients(plate.getIngredients());
        newPlate.setPrice(plate.getPrice());
        newPlate.setRestaurant(restaurantRepository.findById(plate.getRestaurantId()).get());
        newPlate.setCategory(plateCategoryRepository.findById(plate.getCategory()).get());
        Plate plateFromDB = plateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plate not found"));
        newPlate.setId(plateFromDB.getId());
        plateRepository.save(newPlate);
    }

    public void deletePlate(Long id) {
        log.info("Deleting plate with id {}", id);
        plateRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        if (plateRepository.findById(id).isPresent()) {
            plateRepository.deleteById(id);
        }
    }
}
