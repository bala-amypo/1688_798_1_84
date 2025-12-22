package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository,
                                   VehicleRepository vehicleRepository,
                                   GarageRepository garageRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry,
                                           Long vehicleId,
                                           Long garageId) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        Garage garage = garageRepository.findById(garageId).orElse(null);

        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        return serviceEntryRepository.save(entry);
    }

    @Override
    public ServiceEntry getById(Long id) {
        return serviceEntryRepository.findById(id).orElse(null);
    }
}
