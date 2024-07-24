package com.jaynius.caryard.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jaynius.caryard.model.VehicleCategory;
import com.jaynius.caryard.service.VehicleCategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final VehicleCategoryService service;

    @PostMapping("/add")
    public VehicleCategory addCategory(@RequestBody VehicleCategory category) {
        return service.addCategory(category);
    }

    @GetMapping("/")
    public ResponseEntity<List<VehicleCategory>> allCategories() {
        return new ResponseEntity<>(service.categoryList(), HttpStatus.FOUND);
    }

    @GetMapping("/{categoryId}")
    public VehicleCategory geCategoryById(@RequestBody VehicleCategory category, @PathVariable Long categoryId) {
        return service.getCategoryById(categoryId, category);
    }

    @PutMapping("/{categoryId}")
    public VehicleCategory updateCategoryById(VehicleCategory category, Long category)

}
