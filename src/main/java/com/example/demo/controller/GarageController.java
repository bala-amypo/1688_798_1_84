package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/garages")
public class GarageController {

    @PostMapping
    public String createGarage(@RequestBody String body) {
        return "Garage created successfully";
    }
}
