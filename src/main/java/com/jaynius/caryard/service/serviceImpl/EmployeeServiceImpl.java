package com.jaynius.caryard.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaynius.caryard.exception.EmployeeAlreadyExistsException;
import com.jaynius.caryard.exception.EmployeeNotExistException;
import com.jaynius.caryard.model.Employee;
import com.jaynius.caryard.repository.EmployeeRepository;
import com.jaynius.caryard.service.EmpolyeeService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmpolyeeService {

    private final EmployeeRepository repository;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employeeAlreadyExists(employee.getEmail())) {
            throw new EmployeeAlreadyExistsException(employee.getIdNumber() + " already exists");
        }
        return repository.save(employee);
    }

    private boolean employeeAlreadyExists(String email) {
        return repository.findByEmail(email).isPresent();
    }

    @Override
    public List<Employee> allEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Employee employee, String idNumber) {
        return repository.findById(idNumber).orElseThrow(() -> new EmployeeNotExistException("employee not found"));
    }

    @Override
    public Employee updateEmployeeById(Employee employee, String idNumber) {
        return repository.findById(idNumber).map(emp -> {
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setPhone(employee.getPhone());
            emp.setTitle(employee.getTitle());
            emp.setDescription(employee.getDescription());
            return repository.save(employee);
        }).orElseThrow(() -> new EmployeeAlreadyExistsException("employee Exists"));
    }

    @Override
    public void deleteEmployeeById(String idNumber) {
        if (!repository.existsById(idNumber)) {
            throw new EmployeeNotExistException("Employee does not exists");
        }
    }

}
