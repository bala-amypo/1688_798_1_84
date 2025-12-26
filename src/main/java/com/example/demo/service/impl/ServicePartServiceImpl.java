package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;

public class ServicePartServiceImpl {

    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository,
                                  ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    public ServicePart createPart(ServicePart part) {

        ServiceEntry entry = serviceEntryRepository.findById(
                part.getServiceEntry().getId()
        ).orElseThrow(() -> new IllegalArgumentException("ServiceEntry not found"));

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        part.setServiceEntry(entry);
        return servicePartRepository.save(part);
    }
}
