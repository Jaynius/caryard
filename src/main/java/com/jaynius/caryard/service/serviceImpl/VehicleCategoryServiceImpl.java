package com.jaynius.caryard.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaynius.caryard.exception.CategoryAlreadyExistsException;
import com.jaynius.caryard.exception.CategoryDoesNotExistException;
import com.jaynius.caryard.model.VehicleCategory;
import com.jaynius.caryard.repository.CategoryRepository;
import com.jaynius.caryard.service.VehicleCategoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleCategoryServiceImpl implements VehicleCategoryService {
    private final CategoryRepository cRepository;

    @Override
    public VehicleCategory addCategory(VehicleCategory category) {
        if (categoryExist(category.getBodyType())) {
            throw new CategoryAlreadyExistsException(category.getBodyType() + " already exists");
        }
        return cRepository.save(category);
    }

    private boolean categoryExist(String bodyType) {
        return cRepository.findByBodyType(bodyType).isPresent();
    }

    @Override
    public List<VehicleCategory> categoryList() {
        return cRepository.findAll();
    }

    @Override
    public VehicleCategory updVehicleCategory(Long id, VehicleCategory category) {
        return cRepository.findById(id).map(cat -> {
            cat.setBodyType(category.getBodyType());
            cat.setVehicles(category.getVehicles());
            return cRepository.save(category);
        }).orElseThrow(() -> new CategoryDoesNotExistException(category.getCategoryId() + " does not exist"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (!cRepository.existsById(id)) {
            throw new CategoryDoesNotExistException(id + " does not exist");

        }
    }

    @Override
    public VehicleCategory getCategoryById(Long id, VehicleCategory category) {
        return cRepository.findById(id).orElseThrow(() -> new CategoryDoesNotExistException(id + "does not exist"));
    }

}
