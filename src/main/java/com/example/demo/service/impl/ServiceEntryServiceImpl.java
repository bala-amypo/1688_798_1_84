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

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));

        if (!vehicle.getActive()) {
            throw new IllegalArgumentException("Service allowed only for active vehicles");
        }

        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() -> new IllegalArgumentException("Garage not found"));

        if (!garage.getActive()) {
            throw new IllegalArgumentException("Garage inactive");
        }

        if (entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be in future");
        }

        serviceEntryRepository
                .findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException("Odometer must be >= last reading");
                    }
                });

        return serviceEntryRepository.save(entry);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
