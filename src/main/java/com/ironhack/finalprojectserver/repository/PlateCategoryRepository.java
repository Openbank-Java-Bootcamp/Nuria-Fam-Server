package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.PlateCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlateCategoryRepository extends JpaRepository<PlateCategory, Long> {
    @Query(value = "SELECT * FROM plate_category INNER JOIN Restaurant ON plate_category.restaurant_id = restaurant.id WHERE restaurant.id = :id", nativeQuery = true)
    List<PlateCategory> findAllByRestaurant(@Param("id") Long id);
}
