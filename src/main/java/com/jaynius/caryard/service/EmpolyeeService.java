package com.jaynius.caryard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaynius.caryard.model.Employee;

@Service
public interface EmpolyeeService {

    Employee addEmployee(Employee employee);

    List<Employee> allEmployees();

    Employee getEmployeeById(Employee employee, String idNumber);

    Employee updateEmployeeById(Employee employee, String idNumber);

    void deleteEmployeeById(String idNumber);

}
