package com.jaynius.caryard.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.caryard.model.Vehicle;
import com.jaynius.caryard.service.VehicleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.addVehicle(vehicle);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vehicle>> allVehicles() {
        return new ResponseEntity<>(service.vehicleList(), HttpStatus.FOUND);
    }

    @GetMapping("/{chassisNumber}")
    public Vehicle getVehicleById(@RequestBody Vehicle vehicle, @PathVariable String chassisNumber) {
        return service.getVehicleByRegist(chassisNumber, vehicle);
    }

    @PutMapping("/{chassisNumber}")
    public Vehicle updateVehicleById(@RequestBody Vehicle vehicle, @PathVariable String chassisNumber) {
        return service.updateVehicleByChassisNumber(vehicle, chassisNumber);
    }

    @DeleteMapping("/{chassisNumber}")
    public void deleteById(@PathVariable String chassisNumber) {

    }

}
