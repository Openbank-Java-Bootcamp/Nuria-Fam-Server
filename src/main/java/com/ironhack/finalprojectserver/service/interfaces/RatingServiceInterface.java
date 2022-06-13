package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.RatingDTO;
import com.ironhack.finalprojectserver.model.Rating;

import java.util.List;

public interface RatingServiceInterface {
    Rating saveRating(RatingDTO rating);
    List<Rating> getRatings(Long id);
}
