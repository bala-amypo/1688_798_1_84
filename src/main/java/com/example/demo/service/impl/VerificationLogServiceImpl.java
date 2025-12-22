package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.VerificationLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository logRepo;
    private final ServiceEntryRepository entryRepo;

    public VerificationLogServiceImpl(VerificationLogRepository logRepo,
                                      ServiceEntryRepository entryRepo) {
        this.logRepo = logRepo;
        this.entryRepo = entryRepo;
    }

    public VerificationLog save(VerificationLog log, Long entryId) {
        log.setServiceEntry(entryRepo.findById(entryId).orElse(null));
        log.setVerifiedAt(LocalDateTime.now());
        return logRepo.save(log);
    }
}
