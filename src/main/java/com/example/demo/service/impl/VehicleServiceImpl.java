package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
