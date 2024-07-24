package com.jaynius.caryard.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String idNumber;
    private String firstName;
    private String lastName;
    private String title;
    private String description;
    @NaturalId(mutable = true)
    private String email;
    @NaturalId(mutable = true)
    private String phone;

}
