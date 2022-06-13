package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.EmployeeDTO;
import com.ironhack.finalprojectserver.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee getEmployee(Long id);
    List<Employee> getAllEmployees(Long id);
    Employee saveEmployee(EmployeeDTO employee);
    void updateEmployee(Long id, EmployeeDTO employee);
    void deleteEmployee(Long id);
}
