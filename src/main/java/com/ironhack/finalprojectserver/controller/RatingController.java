package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.RatingDTO;
import com.ironhack.finalprojectserver.model.Rating;
import com.ironhack.finalprojectserver.service.interfaces.RatingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {
    @Autowired
    private RatingServiceInterface ratingService;

    @PostMapping("/ratings")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRating(@RequestBody @Valid RatingDTO rating) {
        ratingService.saveRating(rating);
    }

    @GetMapping("/{id}/ratings")
    @ResponseStatus(HttpStatus.OK)
    public List<Rating> getRatings(@PathVariable Long id) {
        return ratingService.getRatings(id);
    }
}
