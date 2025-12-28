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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService service;

    public ServiceEntryController(ServiceEntryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServiceEntry> create(@RequestBody ServiceEntry entry) {
        return ResponseEntity.ok(service.createServiceEntry(entry));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntry> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getServiceEntryById(id));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<ServiceEntry>> getByVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(service.getEntriesForVehicle(vehicleId));
    }

    @GetMapping("/vehicle/{vehicleId}/latest")
    public ResponseEntity<ServiceEntry> getLatest(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(service.getLatestServiceEntry(vehicleId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteServiceEntry(id);
        return ResponseEntity.noContent().build();
    }
}
