package com.jaynius.caryard.service;

import java.util.List;

import com.jaynius.caryard.model.Seller;

public interface SellerService {

    Seller addSeller(Seller seller);

    List<Seller> allSellers();

    Seller updatSellerById(Seller seller, String idNumber);

    Seller getSellerbyId(Seller seller, String idNumber);

    void deleteSellerById(String idNumber);

}
