package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.EmployeeDTO;
import com.ironhack.finalprojectserver.model.Employee;
import com.ironhack.finalprojectserver.service.interfaces.EmployeeServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeServiceInterface employeeService;

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable(name = "id") Long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody @Valid EmployeeDTO employee) {
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeDTO employee) {
        employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
