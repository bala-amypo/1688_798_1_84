package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.VerificationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {
    
    @Autowired
    private VerificationLogRepository verificationLogRepository;
    
    @Autowired
    private ServiceEntryRepository serviceEntryRepository;

    @Override
    public VerificationLog createLog(VerificationLog verificationLog) {
        serviceEntryRepository.findById(verificationLog.getServiceEntry().getId())
                .orElseThrow(() -> new IllegalArgumentException("Service entry not found"));
        
        return verificationLogRepository.save(verificationLog);
    }
}