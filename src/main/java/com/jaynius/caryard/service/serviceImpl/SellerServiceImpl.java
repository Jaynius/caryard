package com.jaynius.caryard.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jaynius.caryard.exception.SellerAlreadyExistsException;
import com.jaynius.caryard.exception.SellerNotFoundException;
import com.jaynius.caryard.model.Seller;
import com.jaynius.caryard.repository.SellerRepository;
import com.jaynius.caryard.service.SellerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Override
    public Seller addSeller(Seller seller) {
        if (SellerExists(seller.getIdNumber())) {
            throw new SellerAlreadyExistsException(seller.getIdNumber() + "already exists");
        }
        return sellerRepository.save(seller);
    }

    private boolean SellerExists(String idNumber) {
        return sellerRepository.findById(idNumber).isPresent();
    }

    @Override
    public List<Seller> allSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller updatSellerById(Seller seller, String idNumber) {
        return sellerRepository.findById(idNumber).map(sel -> {
            sel.setFirstName(seller.getFirstName());
            sel.setLastName(seller.getLastName());
            sel.setIdNumber(seller.getIdNumber());
            sel.setEmail(seller.getEmail());
            sel.setPhone(seller.getPhone());
            // sel.setVehicles(seller.getVehicles());
            return sellerRepository.save(seller);
        }).orElseThrow(() -> new SellerNotFoundException(seller.getIdNumber() + " not found"));
    }

    @Override
    public Seller getSellerbyId(Seller seller, String idNumber) {
        return sellerRepository.findById(idNumber)
                .orElseThrow(() -> new SellerNotFoundException(seller.getIdNumber() + "not found"));
    }

    @Override
    public void deleteSellerById(String idNumber) {
        if (!sellerRepository.findById(idNumber).isPresent()) {
            throw new SellerNotFoundException(idNumber + "not found");
        }
    }

}
