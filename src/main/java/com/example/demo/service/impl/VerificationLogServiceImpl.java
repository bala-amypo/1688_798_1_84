package com.example.demo.service.impl;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository repository;

    public VerificationLogServiceImpl(VerificationLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public VerificationLog save(VerificationLog log) {
        log.setVerifiedAt(LocalDateTime.now());
        return repository.save(log);
    }
}
