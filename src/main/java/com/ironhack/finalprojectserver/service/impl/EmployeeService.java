package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.EmployeeDTO;
import com.ironhack.finalprojectserver.model.Employee;
import com.ironhack.finalprojectserver.repository.EmployeeRepository;
import com.ironhack.finalprojectserver.repository.RestaurantRepository;
import com.ironhack.finalprojectserver.service.interfaces.EmployeeServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Employee getEmployee(Long id) {
        log.info("Fetching employee with id {}", id);
        return employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    public List<Employee> getAllEmployees(Long id) {
        log.info("Fetching all employees");
        return employeeRepository.findAllByRestaurant(id);
    }

    public Employee saveEmployee(EmployeeDTO employee) {
        log.info("Saving a new employee");
        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setJobTitle(employee.getJobTitle());
        newEmployee.setImage(employee.getImage());
        newEmployee.setRestaurant(restaurantRepository.findById(employee.getRestaurantId()).get());
        if (newEmployee.getId() != null) {
            Optional<Employee> employeeFromDB = employeeRepository.findById(newEmployee.getId());
            if (employeeFromDB.isPresent())
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Employee with id " + newEmployee.getId() + " already exist");
        }
        return employeeRepository.save(newEmployee);
    }

    public void updateEmployee(Long id, EmployeeDTO employee) {
        log.info("Updating employee with id {}", id);
        Employee newEmployee = new Employee();
        newEmployee.setName(employee.getName());
        newEmployee.setPhone(employee.getPhone());
        newEmployee.setJobTitle(employee.getJobTitle());
        newEmployee.setImage(employee.getImage());
        newEmployee.setRestaurant(restaurantRepository.findById(employee.getRestaurantId()).get());
        Employee employeeFromDB = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        newEmployee.setId(employeeFromDB.getId());
        employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Long id) {
        log.info("Deleting employee with id {}", id);
        employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
        }
    }
}
