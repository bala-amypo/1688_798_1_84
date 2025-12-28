// package com.example.demo.service;

// import com.example.demo.model.ServiceEntry;
// import java.util.List;

// public interface ServiceEntryService {
//     ServiceEntry createServiceEntry(ServiceEntry serviceEntry);
//     List<ServiceEntry> getEntriesForVehicle(Long vehicleId);
// }

package com.example.demo.service;

import com.example.demo.entity.ServiceEntry;

import java.util.List;
import java.util.Optional;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry serviceEntry);

    List<ServiceEntry> getAllServiceEntries();

    Optional<ServiceEntry> getServiceEntryById(Long id);

    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

    Optional<ServiceEntry> getLatestServiceEntry(Long vehicleId);

    void deleteServiceEntry(Long id);
}
