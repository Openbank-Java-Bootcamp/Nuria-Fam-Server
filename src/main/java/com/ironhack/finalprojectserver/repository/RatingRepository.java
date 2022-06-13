package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query(value = "SELECT * FROM Rating INNER JOIN Restaurant ON rating.restaurant_id = restaurant.id WHERE restaurant.id = :id", nativeQuery = true)
    List<Rating> findAllByRestaurant(@Param("id") Long id);
}
