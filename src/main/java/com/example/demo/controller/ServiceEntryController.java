// package com.example.demo.controller;

// import com.example.demo.model.ServiceEntry;
// import com.example.demo.service.ServiceEntryService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/service-entries")
// public class ServiceEntryController {

//     @Autowired
//     private ServiceEntryService serviceEntryService;

//     @PostMapping
//     public ResponseEntity<ServiceEntry> createServiceEntry(@RequestBody ServiceEntry serviceEntry) {
//         ServiceEntry savedEntry = serviceEntryService.createServiceEntry(serviceEntry);
//         return ResponseEntity.ok(savedEntry);
//     }

//     @GetMapping("/vehicle/{vehicleId}")
//     public ResponseEntity<List<ServiceEntry>> getEntriesForVehicle(@PathVariable Long vehicleId) {
//         List<ServiceEntry> entries = serviceEntryService.getEntriesForVehicle(vehicleId);
//         return ResponseEntity.ok(entries);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/{vehicleId}/services")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // ✅ CREATE service entry (FIXED)
    @PostMapping
    public ResponseEntity<ServiceEntry> createServiceEntry(
            @PathVariable Long vehicleId,
            @RequestBody ServiceEntry serviceEntry) {

        ServiceEntry created =
                serviceEntryService.createServiceEntry(vehicleId, serviceEntry);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // ✅ GET all service entries for a vehicle
    @GetMapping
    public ResponseEntity<List<ServiceEntry>> getEntriesForVehicle(
            @PathVariable Long vehicleId) {

        return ResponseEntity.ok(
                serviceEntryService.getEntriesForVehicle(vehicleId)
        );
    }

    // ✅ GET latest service entry
    @GetMapping("/latest")
    public ResponseEntity<ServiceEntry> getLatestServiceEntry(
            @PathVariable Long vehicleId) {

        return ResponseEntity.ok(
                serviceEntryService.getLatestServiceEntry(vehicleId)
        );
    }

    // ✅ GET service entry by id
    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntry> getServiceEntryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                serviceEntryService.getServiceEntryById(id)
        );
    }

    // ✅ DELETE service entry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceEntry(
            @PathVariable Long id) {

        serviceEntryService.deleteServiceEntry(id);
        return ResponseEntity.noContent().build();
    }
}
