// package com.example.demo.service.impl;

// import com.example.demo.model.ServiceEntry;
// import com.example.demo.model.Vehicle;
// import com.example.demo.model.Garage;
// import com.example.demo.repository.ServiceEntryRepository;
// import com.example.demo.repository.VehicleRepository;
// import com.example.demo.repository.GarageRepository;
// import com.example.demo.service.ServiceEntryService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class ServiceEntryServiceImpl implements ServiceEntryService {
    
//     @Autowired
//     private ServiceEntryRepository serviceEntryRepository;
    
//     @Autowired
//     private VehicleRepository vehicleRepository;
    
//     @Autowired
//     private GarageRepository garageRepository;

//     @Override
//     public ServiceEntry createServiceEntry(ServiceEntry serviceEntry) {
//         Vehicle vehicle = vehicleRepository.findById(serviceEntry.getVehicle().getId())
//                 .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
        
//         Garage garage = garageRepository.findById(serviceEntry.getGarage().getId())
//                 .orElseThrow(() -> new IllegalArgumentException("Garage not found"));
        
//         if (!vehicle.getActive()) {
//             throw new IllegalArgumentException("Service entries can only be created for active vehicles");
//         }
        
//         if (serviceEntry.getServiceDate().isAfter(LocalDate.now())) {
//             throw new IllegalArgumentException("Service date cannot be in the future");
//         }
        
//         Optional<ServiceEntry> lastEntry = serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(vehicle);
//         if (lastEntry.isPresent() && serviceEntry.getOdometerReading() < lastEntry.get().getOdometerReading()) {
//             throw new IllegalArgumentException("Odometer reading must be >= previous reading");
//         }
        
//         return serviceEntryRepository.save(serviceEntry);
//     }

//     @Override
//     public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
//         return serviceEntryRepository.findByVehicleId(vehicleId);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository,
                                   VehicleRepository vehicleRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
    }

    // ================= CREATE =================

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry serviceEntry) {
        if (serviceEntry.getVehicle() == null || serviceEntry.getVehicle().getId() == null) {
            throw new IllegalArgumentException("Vehicle is required");
        }

        Long vehicleId = serviceEntry.getVehicle().getId();

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found with id: " + vehicleId));

        serviceEntry.setVehicle(vehicle);
        return serviceEntryRepository.save(serviceEntry);
    }

    // Optional helper (NOT part of interface – no @Override)
    public ServiceEntry createServiceEntry(Long vehicleId, ServiceEntry serviceEntry) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found with id: " + vehicleId));

        serviceEntry.setVehicle(vehicle);
        return serviceEntryRepository.save(serviceEntry);
    }

    // ================= READ =================

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryRepository.findAll();
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("ServiceEntry not found with id: " + id));
    }

    @Override
    public List<ServiceEntry> getServiceEntriesByVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }

    // ================= LATEST SERVICE =================

    @Override
    public ServiceEntry getLatestServiceEntry(Long vehicleId) {
        List<ServiceEntry> entries = serviceEntryRepository.findByVehicleId(vehicleId);

        if (entries.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No service entries found for vehicle id: " + vehicleId);
        }

        return entries.stream()
                .max(Comparator.comparing(ServiceEntry::getServiceDate))
                .orElseThrow();
    }

    // ================= DELETE =================

    @Override
    public void deleteServiceEntry(Long id) {
        ServiceEntry entry = getServiceEntryById(id);
        serviceEntryRepository.delete(entry);
    }
}
