package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VerificationLogRepository;

import java.time.LocalDateTime;

public class VerificationLogServiceImpl {

    private final VerificationLogRepository verificationLogRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public VerificationLogServiceImpl(VerificationLogRepository verificationLogRepository,
                                      ServiceEntryRepository serviceEntryRepository) {
        this.verificationLogRepository = verificationLogRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    public VerificationLog createLog(VerificationLog log) {

        ServiceEntry entry = serviceEntryRepository.findById(
                log.getServiceEntry().getId()
        ).orElseThrow(() -> new IllegalArgumentException("ServiceEntry not found"));

        log.setServiceEntry(entry);
        log.setVerifiedAt(LocalDateTime.now());

        return verificationLogRepository.save(log);
    }
}
