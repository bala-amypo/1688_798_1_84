package com.example.demo.service;

import com.example.demo.model.VerificationLog;

public interface VerificationLogService {
    VerificationLog addLog(VerificationLog log, Long serviceEntryId);
}
