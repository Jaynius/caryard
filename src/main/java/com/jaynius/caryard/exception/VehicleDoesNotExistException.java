package com.jaynius.caryard.exception;

public class VehicleDoesNotExistException extends RuntimeException {

    public VehicleDoesNotExistException(String message) {
        super(message);
    }
}
