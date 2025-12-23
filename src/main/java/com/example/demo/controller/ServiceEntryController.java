package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService service;

    public ServiceEntryController(ServiceEntryService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry serviceEntry) {
        return service.save(serviceEntry);
    }

    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getByGarage(
            @PathVariable Long garageId,
            @RequestParam int minOdometer) {

        return service.getByGarageAndMinOdometer(garageId, minOdometer);
    }
}
