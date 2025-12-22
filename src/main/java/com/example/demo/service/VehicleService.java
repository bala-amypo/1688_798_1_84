package com.example.demo.service;

import com.example.demo.model.Vehicle;

public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    Vehicle getById(Long id);
}
