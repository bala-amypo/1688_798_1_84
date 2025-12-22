package com.example.demo.service;

import com.example.demo.model.ServiceEntry;

public interface ServiceEntryService {

    ServiceEntry createServiceEntry(ServiceEntry entry, Long vehicleId, Long garageId);

    ServiceEntry getById(Long id);
}
