package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.PlateCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlateCategoryRepository extends JpaRepository<PlateCategory, Long> {
}
