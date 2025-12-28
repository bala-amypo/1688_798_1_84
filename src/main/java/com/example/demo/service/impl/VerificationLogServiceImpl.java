// package com.example.demo.service.impl;

// import com.example.demo.model.VerificationLog;
// import com.example.demo.repository.VerificationLogRepository;
// import com.example.demo.repository.ServiceEntryRepository;
// import com.example.demo.service.VerificationLogService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class VerificationLogServiceImpl implements VerificationLogService {
    
//     @Autowired
//     private VerificationLogRepository verificationLogRepository;
    
//     @Autowired
//     private ServiceEntryRepository serviceEntryRepository;

//     @Override
//     public VerificationLog createLog(VerificationLog verificationLog) {
//         serviceEntryRepository.findById(verificationLog.getServiceEntry().getId())
//                 .orElseThrow(() -> new IllegalArgumentException("Service entry not found"));
        
//         return verificationLogRepository.save(verificationLog);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.VerificationLog;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VerificationLogRepository;
import com.example.demo.service.VerificationLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository verificationLogRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public VerificationLogServiceImpl(VerificationLogRepository verificationLogRepository,
                                      ServiceEntryRepository serviceEntryRepository) {
        this.verificationLogRepository = verificationLogRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public VerificationLog createLog(VerificationLog log) {
        ServiceEntry entry = serviceEntryRepository.findById(
                log.getServiceEntry().getId())
                .orElseThrow(() -> new IllegalArgumentException("Service entry not found"));

        log.setServiceEntry(entry);
        log.setVerifiedAt(LocalDateTime.now());
        return verificationLogRepository.save(log);
    }
}
