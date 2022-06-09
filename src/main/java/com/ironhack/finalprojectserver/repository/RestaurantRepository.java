package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "SELECT * FROM Restaurant INNER JOIN User ON restaurant.user_id = user.id WHERE user.id = :id GROUP BY restaurant.user_id", nativeQuery = true)
    List<Restaurant> findRestaurantsByUserId(@Param("id") Long id);
}
