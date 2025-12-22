package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository partRepository;
    private final ServiceEntryRepository entryRepository;

    public ServicePartServiceImpl(ServicePartRepository partRepository,
                                  ServiceEntryRepository entryRepository) {
        this.partRepository = partRepository;
        this.entryRepository = entryRepository;
    }

    @Override
    public ServicePart createPart(ServicePart part) {
        ServiceEntry entry = entryRepository.findById(
                part.getServiceEntry().getId()
        ).orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        part.setServiceEntry(entry);
        return partRepository.save(part);
    }
}
