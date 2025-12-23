package com.example.demo.service.impl;

import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository verificationLogRepository;

    public VerificationLogServiceImpl(VerificationLogRepository verificationLogRepository) {
        this.verificationLogRepository = verificationLogRepository;
    }

    @Override
    public VerificationLog createLog(VerificationLog log) {
        return verificationLogRepository.save(log);
    }

    @Override
    public VerificationLog getLogById(Long id) {
        return verificationLogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("VerificationLog not found"));
    }

    @Override
    public List<VerificationLog> getLogsForEntry(Long entryId) {
        return verificationLogRepository.findAll()
                .stream()
                .filter(l -> l.getServiceEntry().getId().equals(entryId))
                .toList();
    }
}
