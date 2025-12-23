package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository entryRepo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(
            ServiceEntryRepository entryRepo,
            VehicleRepository vehicleRepo,
            GarageRepository garageRepo) {
        this.entryRepo = entryRepo;
        this.vehicleRepo = vehicleRepo;
        this.garageRepo = garageRepo;
    }

    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Vehicle vehicle = vehicleRepo.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        if (!vehicle.getActive())
            throw new IllegalArgumentException("active vehicles");

        if (entry.getServiceDate().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("future");

        entryRepo.findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading())
                        throw new IllegalArgumentException(">=");
                });

        Garage garage = garageRepo.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        if (!garage.getActive())
            throw new IllegalArgumentException("Garage inactive");

        return entryRepo.save(entry);
    }

    public ServiceEntry getServiceEntryById(Long id) {
        return entryRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));
    }

    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return entryRepo.findByVehicleId(vehicleId);
    }
}
