package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    @PostMapping("/{vehicleId}/{garageId}")
    public ServiceEntry create(@RequestBody ServiceEntry entry,
                               @PathVariable Long vehicleId,
                               @PathVariable Long garageId) {
        return serviceEntryService.createServiceEntry(entry, vehicleId, garageId);
    }

    @GetMapping("/{id}")
    public ServiceEntry getById(@PathVariable Long id) {
        return serviceEntryService.getById(id);
    }
}
