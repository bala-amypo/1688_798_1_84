// package com.example.demo.controller;

// import com.example.demo.model.Garage;
// import com.example.demo.service.GarageService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/garages")
// public class GarageController {

//     @Autowired
//     private GarageService garageService;

//     @PostMapping
//     public ResponseEntity<Garage> createGarage(@RequestBody Garage garage) {
//         Garage savedGarage = garageService.createGarage(garage);
//         return ResponseEntity.ok(savedGarage);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/garages")
public class GarageController {

    private final GarageService service;

    public GarageController(GarageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Garage> create(@RequestBody Garage garage) {
        return ResponseEntity.ok(service.createGarage(garage));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garage> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getGarageById(id));
    }
}
