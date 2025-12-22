package com.example.demo.service;

import com.example.demo.model.ServicePart;

public interface ServicePartService {

    ServicePart addServicePart(ServicePart part, Long serviceEntryId);
}
