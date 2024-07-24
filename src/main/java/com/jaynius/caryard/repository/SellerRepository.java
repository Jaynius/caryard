package com.jaynius.caryard.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaynius.caryard.model.Seller;
import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {
    // Optional<Seller> findByIdNumber(String idNumber);
}
