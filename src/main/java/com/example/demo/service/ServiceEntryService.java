// package com.example.demo.service;

// import com.example.demo.model.ServiceEntry;
// import java.util.List;

// public interface ServiceEntryService {
//     ServiceEntry createServiceEntry(ServiceEntry serviceEntry);
//     List<ServiceEntry> getEntriesForVehicle(Long vehicleId);
// }

package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(Long vehicleId, ServiceEntry serviceEntry);

    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

    ServiceEntry getLatestServiceEntry(Long vehicleId);

    List<ServiceEntry> getEntriesByGarageAndMinOdometer(long garageId, int minOdometer);

    List<ServiceEntry> getEntriesByVehicleAndDateRange(
            long vehicleId,
            LocalDate startDate,
            LocalDate endDate
    );

    void deleteServiceEntry(Long serviceEntryId);
}
