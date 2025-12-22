package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository entryRepo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository entryRepo,
                                   VehicleRepository vehicleRepo,
                                   GarageRepository garageRepo) {
        this.entryRepo = entryRepo;
        this.vehicleRepo = vehicleRepo;
        this.garageRepo = garageRepo;
    }

    public ServiceEntry create(ServiceEntry entry, Long vehicleId, Long garageId) {
        entry.setVehicle(vehicleRepo.findById(vehicleId).orElse(null));
        entry.setGarage(garageRepo.findById(garageId).orElse(null));
        return entryRepo.save(entry);
    }
}
