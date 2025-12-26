package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
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
    public ServiceEntry create(@RequestBody ServiceEntry e) {
        return service.createServiceEntry(e);
    }

    @GetMapping("/vehicle/{id}")
    public List<ServiceEntry> get(@PathVariable Long id) {
        return service.getEntriesForVehicle(id);
    }
}
