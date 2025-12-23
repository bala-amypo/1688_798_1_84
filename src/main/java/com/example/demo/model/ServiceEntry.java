package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int odometer;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;   // 🔴 THIS FIXES THE ERROR

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

    // getters & setters
    public Long getId() {
        return id;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
