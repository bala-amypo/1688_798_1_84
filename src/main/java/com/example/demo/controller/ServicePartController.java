package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    @Autowired
    private ServicePartService servicePartService;

    @PostMapping
    public ResponseEntity<ServicePart> createServicePart(@RequestBody ServicePart servicePart) {
        ServicePart savedPart = servicePartService.createPart(servicePart);
        return ResponseEntity.ok(savedPart);
    }
}