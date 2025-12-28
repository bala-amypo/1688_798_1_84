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

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repository;

    public ServiceEntryServiceImpl(ServiceEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        return repository.save(entry);
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service entry not found"));
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return repository.findByVehicleId(vehicleId);
    }

    @Override
    public ServiceEntry getLatestServiceEntry(Long vehicleId) {
        return repository.findTopByVehicleIdOrderByServiceDateDesc(vehicleId)
                .orElseThrow(() -> new RuntimeException("No service entries found"));
    }

    @Override
    public void deleteServiceEntry(Long id) {
        repository.deleteById(id);
    }
}
