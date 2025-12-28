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