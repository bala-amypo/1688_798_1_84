// package com.example.demo.service;

// import com.example.demo.model.ServiceEntry;
// import java.util.List;

// public interface ServiceEntryService {
//     ServiceEntry createServiceEntry(ServiceEntry serviceEntry);
//     List<ServiceEntry> getEntriesForVehicle(Long vehicleId);
// }

ppackage com.example.demo.service;

import com.example.demo.model.ServiceEntry;

import java.util.List;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(Long vehicleId, ServiceEntry serviceEntry);

    List<ServiceEntry> getEntriesForVehicle(Long vehicleId);

    ServiceEntry getLatestServiceEntry(Long vehicleId);

    ServiceEntry getServiceEntryById(Long id);

    void deleteServiceEntry(Long id);
}
