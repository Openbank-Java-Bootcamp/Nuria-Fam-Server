package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    @Query(value = "SELECT * FROM Drink INNER JOIN drink_category ON drink.category_id = drink_category.id WHERE drink_category.id = :id GROUP BY drink.category_id", nativeQuery = true)
    List<Drink> findByCategory(@Param("id") Long categoryId);
}
