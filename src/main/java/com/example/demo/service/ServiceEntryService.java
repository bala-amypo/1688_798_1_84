package com.example.demo.service;

import com.example.demo.model.ServiceEntry;
import java.util.List;

public interface ServiceEntryService {

    ServiceEntry save(ServiceEntry serviceEntry);

    List<ServiceEntry> getByGarageAndMinOdometer(Long garageId, int minOdometer);
}
