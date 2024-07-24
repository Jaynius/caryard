package com.jaynius.caryard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaynius.caryard.model.Vehicle;

@Service
public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);

    List<Vehicle> vehicleList();

    Vehicle getVehicleByRegist(String vRegNo, Vehicle vehicle);

    void deleteVehicleByChassiss(String chassisNumber);

    Vehicle updateVehicleByChassisNumber(Vehicle vehicle, String chassisNumber);

}
