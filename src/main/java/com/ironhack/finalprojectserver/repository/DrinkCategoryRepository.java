package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.DrinkCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkCategoryRepository extends JpaRepository<DrinkCategory, Long> {
}
