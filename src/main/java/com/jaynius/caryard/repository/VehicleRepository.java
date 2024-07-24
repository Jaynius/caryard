package com.jaynius.caryard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaynius.caryard.model.Vehicle;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Optional<Vehicle> findByVRegno(String vRegno);

    // Optional<Vehicle> findByChassisNumber(String chassisNumber);

    void deleteByChassisNumber(String ChassisNumber);
}
