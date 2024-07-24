package com.jaynius.caryard.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaynius.caryard.exception.VehicleAlreadyExistsException;
import com.jaynius.caryard.exception.VehicleDoesNotExistException;
import com.jaynius.caryard.model.Vehicle;
import com.jaynius.caryard.repository.VehicleRepository;
import com.jaynius.caryard.service.VehicleService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        if (vehicleExists(vehicle.getChassisNumber())) {
            throw new VehicleAlreadyExistsException(vehicle.getChassisNumber() + "already exists");

        }
        return vRepository.save(vehicle);
    }

    private boolean vehicleExists(String chassisNumber) {
        return vRepository.findById(chassisNumber).isPresent();
    }

    @Override
    public List<Vehicle> vehicleList() {
        return vRepository.findAll();
    }

    @Override
    public Vehicle getVehicleByRegist(String vRegNo, Vehicle vehicle) {
        return vRepository.findByVRegno(vRegNo)
                .orElseThrow(() -> new VehicleDoesNotExistException(vehicle.getVRegno() + "does not exists"));
    }

    @Override
    public void deleteVehicleByChassiss(String chassisNumber) {
        if (!vehicleExists(chassisNumber)) {
            throw new VehicleDoesNotExistException(chassisNumber + "does not exist");
        }
        vRepository.deleteByChassisNumber(chassisNumber);
    }

    @Override
    public Vehicle updateVehicleByChassisNumber(Vehicle vehicle, String chassisNumber) {
        return vRepository.findById(chassisNumber).map(v -> {
            v.setAccelaration(vehicle.getAccelaration());
            v.setAspiration(vehicle.getAspiration());
            v.setCategory(vehicle.getCategory());
            v.setColor(vehicle.getColor());
            v.setComfortFeatures(vehicle.getComfortFeatures());
            v.setCondition(vehicle.getCondition());
            v.setDrive(vehicle.getDrive());
            v.setEngineSize(vehicle.getEngineSize());
            v.setFuelType(vehicle.getFuelType());
            v.setHorsePower(vehicle.getHorsePower());
            v.setMake(vehicle.getMake());
            v.setMilage(vehicle.getMilage());
            v.setModel(vehicle.getModel());
            v.setSafetyFeatures(vehicle.getSafetyFeatures());
            v.setSeller(vehicle.getSeller());
            v.setTransmission(vehicle.getTransmission());
            v.setVRegno(vehicle.getVRegno());
            v.setYearOfManufacture(vehicle.getYearOfManufacture());
            return vRepository.save(vehicle);

        }).orElseThrow(() -> new VehicleDoesNotExistException(chassisNumber + " does not exist in database"));

    }

}
