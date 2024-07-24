package com.jaynius.caryard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.caryard.model.Employee;
import com.jaynius.caryard.service.EmpolyeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmpolyeeService empService;

    @PostMapping("/add")
    public Employee employeeAdd(@RequestBody Employee employee) {
        return empService.addEmployee(employee);

    }

    @GetMapping
    public ResponseEntity<List<Employee>> allEmployee() {
        return new ResponseEntity<>(empService.allEmployees(), HttpStatus.FOUND);
    }

    @PutMapping("/{idNumber}")
    public ResponseEntity<Employee> updateEmployeeByIdNumber(@RequestBody Employee employee,
            @PathVariable String idNumber) {
        return new ResponseEntity<>(empService.updateEmployeeById(employee, idNumber), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idNumber}")
    public Employee findEmployeeByIdNumber(@RequestBody Employee employee, @PathVariable String idNumber) {
        return empService.getEmployeeById(employee, idNumber);
    }

    @DeleteMapping("/{idNumber}")
    public void deleteEmployeeById(@PathVariable String idNumber) {
        empService.deleteEmployeeById(idNumber);
    }

}