package com.jaynius.caryard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaynius.caryard.model.VehicleCategory;

@Repository
public interface CategoryRepository extends JpaRepository<VehicleCategory, Long> {

    Optional<VehicleCategory> findByBodyType(String bodyType);
}
