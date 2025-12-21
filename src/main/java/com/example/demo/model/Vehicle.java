package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicles", uniqueConstraints = @UniqueConstraint(columnNames = "vin"))
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vin;
    private String make;
    private String model;
    private Long ownerId;
    private Boolean active;

    @OneToMany(mappedBy = "vehicle")
    private List<ServiceEntry> serviceEntries;

    public Vehicle() {}

    public Vehicle(String vin, String make, String model, Long ownerId, Boolean active) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.ownerId = ownerId;
        this.active = active;
    }

    // getters & setters
}
