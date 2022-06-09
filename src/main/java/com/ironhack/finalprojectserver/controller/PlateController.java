package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.PlateDTO;
import com.ironhack.finalprojectserver.DTO.RestaurantDTO;
import com.ironhack.finalprojectserver.model.*;
import com.ironhack.finalprojectserver.service.interfaces.PlateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlateController {
    @Autowired
    private PlateServiceInterface plateService;

    @GetMapping("/plates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Plate getPlate(@PathVariable(name = "id") Long id) {
        return plateService.getPlate(id);
    }

    @GetMapping("/plates/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Plate> getPlateByCategory(@PathVariable(name = "id") Long id) {
        return plateService.getPlatesByCategory(id);
    }

    @PostMapping("/plates")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlate(@RequestBody @Valid PlateDTO plate) {
        plateService.savePlate(plate);
    }

    @PutMapping("/plates/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlate(@PathVariable Long id, @RequestBody @Valid PlateDTO plate) {
        plateService.updatePlate(id, plate);
    }

    @DeleteMapping("/plates/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlate(@PathVariable Long id) {
        plateService.deletePlate(id);
    }
}
