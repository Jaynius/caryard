package com.jaynius.caryard.exception;

public class EmployeeNotExistException extends RuntimeException {

    public EmployeeNotExistException(String message) {
        super(message);
    }
}
