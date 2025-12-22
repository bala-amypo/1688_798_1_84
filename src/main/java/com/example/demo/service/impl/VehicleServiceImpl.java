package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repo;

    public VehicleServiceImpl(VehicleRepository repo) {
        this.repo = repo;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        if (repo.findByVin(vehicle.getVin()).isPresent()) {
            throw new IllegalArgumentException("VIN already exists");
        }
        return repo.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        return repo.findByVin(vin)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    @Override
    public List<Vehicle> getVehiclesByOwner(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    @Override
    public void deactivateVehicle(Long id) {
        Vehicle v = getVehicleById(id);
        v.setActive(false);
        repo.save(v);
    }
}
