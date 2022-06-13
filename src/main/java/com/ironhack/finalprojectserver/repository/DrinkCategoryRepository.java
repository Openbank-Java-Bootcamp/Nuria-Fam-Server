package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.DrinkCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkCategoryRepository extends JpaRepository<DrinkCategory, Long> {
    @Query(value = "SELECT * FROM drink_category INNER JOIN Restaurant ON drink_category.restaurant_id = restaurant.id WHERE restaurant.id = :id GROUP BY drink_category.restaurant_id", nativeQuery = true)
    List<DrinkCategory> findAllByRestaurant(@Param("id") Long id);
}
