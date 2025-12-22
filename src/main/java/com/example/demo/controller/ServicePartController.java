package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping("/{serviceEntryId}")
    public ServicePart addPart(@RequestBody ServicePart part,
                               @PathVariable Long serviceEntryId) {
        return servicePartService.addServicePart(part, serviceEntryId);
    }
}
