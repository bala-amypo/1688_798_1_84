package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository partRepo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(ServicePartRepository partRepo,
                                  ServiceEntryRepository entryRepo) {
        this.partRepo = partRepo;
        this.entryRepo = entryRepo;
    }

    public ServicePart save(ServicePart part, Long entryId) {
        part.setServiceEntry(entryRepo.findById(entryId).orElse(null));
        return partRepo.save(part);
    }
}
