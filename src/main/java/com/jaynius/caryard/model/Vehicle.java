package com.jaynius.caryard.model;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@ToString
@Setter
public class Vehicle {

    // @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    // private Long id;
    // @Column(unique = true)
    @Id
    private String chassisNumber;
    @Column(unique = true)
    private String vRegno;
    private String make;
    private String model;
    private String color;
    private String drive;
    private Integer milage;
    private String fuelType;
    private String horsePower;
    private LocalDate yearOfManufacture;
    private String engineSize;
    private String transmission;
    private String aspiration;
    private String accelaration;
    private String condition;

    @ElementCollection
    private List<String> safetyFeatures = new ArrayList<>();
    @ElementCollection
    private List<String> comfortFeatures = new ArrayList<>();
    private List<Blob> images = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private VehicleCategory category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleImages> vehicleImages;

}
