package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository repository;

    public ServiceEntryServiceImpl(ServiceEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceEntry save(ServiceEntry serviceEntry) {
        return repository.save(serviceEntry);
    }

    @Override
    public List<ServiceEntry> getByGarageAndMinOdometer(Long garageId, int minOdometer) {
        return repository.findByGarageIdAndOdometerGreaterThanEqual(garageId, minOdometer);
    }
}
