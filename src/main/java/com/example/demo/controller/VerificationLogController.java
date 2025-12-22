package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verification-logs")
public class VerificationLogController {

    private final VerificationLogService verificationLogService;

    public VerificationLogController(VerificationLogService verificationLogService) {
        this.verificationLogService = verificationLogService;
    }

    @PostMapping("/{serviceEntryId}")
    public VerificationLog create(@RequestBody VerificationLog log,
                                  @PathVariable Long serviceEntryId) {
        return verificationLogService.createLog(log, serviceEntryId);
    }
}
