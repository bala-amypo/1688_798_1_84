package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
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
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
    Vehicle saved = vehicleService.saveVehicle(vehicle);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @GetMapping("/{id}")
    public Vehicle get(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
        return service.getVehiclesByOwner(ownerId);
    }
}
