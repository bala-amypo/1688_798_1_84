// package com.example.demo.controller;

// import com.example.demo.model.Vehicle;
// import com.example.demo.service.VehicleService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/vehicles")
// public class VehicleController {

//     @Autowired
//     private VehicleService vehicleService;

//     @PostMapping
//     public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
//         Vehicle savedVehicle = vehicleService.createVehicle(vehicle);
//         return ResponseEntity.ok(savedVehicle);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
//         Vehicle vehicle = vehicleService.getVehicleById(id);
//         return ResponseEntity.ok(vehicle);
//     }

//     @GetMapping("/owner/{ownerId}")
//     public ResponseEntity<List<Vehicle>> getVehiclesByOwner(@PathVariable Long ownerId) {
//         List<Vehicle> vehicles = vehicleService.getVehiclesByOwner(ownerId);
//         return ResponseEntity.ok(vehicles);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deactivateVehicle(@PathVariable Long id) {
//         vehicleService.deactivateVehicle(id);
//         return ResponseEntity.ok().build();
//     }
// }