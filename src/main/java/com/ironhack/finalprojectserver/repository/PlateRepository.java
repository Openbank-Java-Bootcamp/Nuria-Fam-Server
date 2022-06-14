package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.Plate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlateRepository extends JpaRepository<Plate, Long> {
    @Query(value = "SELECT * FROM Plate INNER JOIN plate_category ON plate.category_id = plate_category.id WHERE plate_category.id = :id", nativeQuery = true)
    List<Plate> findByCategory(@Param("id") Long categoryId); // Get plates of one category
}
