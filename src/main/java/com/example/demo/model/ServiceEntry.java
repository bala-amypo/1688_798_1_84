package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // IMPORTANT: field name = garageId
    private Long garageId;

    // IMPORTANT: field name = odometer
    private int odometer;

    private String description;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getGarageId() { return garageId; }
    public void setGarageId(Long garageId) { this.garageId = garageId; }

    public int getOdometer() { return odometer; }
    public void setOdometer(int odometer) { this.odometer = odometer; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
