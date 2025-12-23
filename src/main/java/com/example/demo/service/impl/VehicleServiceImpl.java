package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        vehicle.setActive(true);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getVehiclesByOwner(Long ownerId) {
        // ✅ FIXED METHOD NAME
        return vehicleRepository.findByOwner_Id(ownerId);
    }

    @Override
    public Vehicle deactivateVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicle.setActive(false);
        return vehicleRepository.save(vehicle);
    }
}
