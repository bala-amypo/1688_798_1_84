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

package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(service.createVehicle(vehicle));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getVehicleById(id));
    }

    @GetMapping("/vin/{vin}")
    public ResponseEntity<Vehicle> getByVin(@PathVariable String vin) {
        return ResponseEntity.ok(service.getVehicleByVin(vin));
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Vehicle>> getByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(service.getVehiclesByOwner(ownerId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivateVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
