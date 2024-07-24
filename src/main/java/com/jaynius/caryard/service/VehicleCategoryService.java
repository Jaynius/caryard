package com.jaynius.caryard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaynius.caryard.model.VehicleCategory;

@Service
public interface VehicleCategoryService {

    VehicleCategory addCategory(VehicleCategory category);

    List<VehicleCategory> categoryList();

    VehicleCategory updVehicleCategory(Long id, VehicleCategory category);

    void deleteCategoryById(Long id);

    VehicleCategory getCategoryById(Long id, VehicleCategory c);
}
