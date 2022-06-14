package com.ironhack.finalprojectserver.repository;

import com.ironhack.finalprojectserver.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM Employee INNER JOIN Restaurant ON employee.restaurant_id = restaurant.id WHERE restaurant.id = :id", nativeQuery = true)
    List<Employee> findAllByRestaurant(@Param("id") Long id); // Get employees of one restaurant
}
