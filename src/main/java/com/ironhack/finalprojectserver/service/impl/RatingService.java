package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.RatingDTO;
import com.ironhack.finalprojectserver.model.Rating;
import com.ironhack.finalprojectserver.repository.RatingRepository;
import com.ironhack.finalprojectserver.repository.RestaurantRepository;
import com.ironhack.finalprojectserver.repository.UserRepository;
import com.ironhack.finalprojectserver.service.interfaces.RatingServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class RatingService implements RatingServiceInterface {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Rating saveRating(RatingDTO rating) {
        log.info("Saving a new rating {}", rating.getRating());
        Rating newRating = new Rating();
        newRating.setRating(rating.getRating());
        newRating.setRestaurant(restaurantRepository.findById(rating.getRestaurantId()).get());
        return ratingRepository.save(newRating);
    }

    public List<Rating> getRatings(Long id) {
        log.info("Fetching all ratings");
        return ratingRepository.findAllByRestaurant(id);
    }
}
