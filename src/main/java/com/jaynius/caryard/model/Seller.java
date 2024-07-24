package com.jaynius.caryard.model;

import java.sql.Blob;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Seller {

    @Id
    private String idNumber;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    // private Blob image;
    // private Blob idFront;
    // private Blob idBack;

    @OneToMany(mappedBy = "seller")
    private List<Vehicle> vehicles;
}
