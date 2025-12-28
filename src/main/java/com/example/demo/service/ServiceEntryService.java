// package com.example.demo.service;

// import com.example.demo.model.ServiceEntry;
// import java.util.List;

// public interface ServiceEntryService {
//     ServiceEntry createServiceEntry(ServiceEntry serviceEntry);
//     List<ServiceEntry> getEntriesForVehicle(Long vehicleId);
// }

package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(Long vehicleId, ServiceEntry serviceEntry);

    // Required by tests
    ServiceEntry createServiceEntry(ServiceEntry serviceEntry);

    ServiceEntry getServiceEntryById(Long id);

    List<ServiceEntry> getAllServiceEntries();
}
