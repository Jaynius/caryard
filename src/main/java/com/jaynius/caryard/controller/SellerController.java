package com.jaynius.caryard.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaynius.caryard.model.Seller;
import com.jaynius.caryard.service.SellerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController {

    private final SellerService service;

    @PostMapping("/add")
    public Seller addSeller(@RequestBody Seller seller) {
        return service.addSeller(seller);
    }

    @GetMapping
    public ResponseEntity<List<Seller>> allSellers() {
        return new ResponseEntity<>(service.allSellers(), HttpStatus.FOUND);
    }

    @PutMapping("/{idNumber}")
    public Seller updateSeller(@RequestBody Seller seller, @PathVariable String idNumber) {
        return service.updatSellerById(seller, idNumber);
    }

    @GetMapping("/{idNumber}")
    public Seller getSellerById(@PathVariable String idNumber, @RequestBody Seller seller) {
        return service.getSellerbyId(seller, idNumber);
    }

    @DeleteMapping("/{idNumber}")
    public void deleteSellerById(@PathVariable String idNumber) {
        service.deleteSellerById(idNumber);
    }

}
