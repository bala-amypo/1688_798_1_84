// package com.example.demo.controller;

// import com.example.demo.model.VerificationLog;
// import com.example.demo.service.VerificationLogService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/verification-logs")
// public class VerificationLogController {

//     @Autowired
//     private VerificationLogService verificationLogService;

//     @PostMapping
//     public ResponseEntity<VerificationLog> createVerificationLog(@RequestBody VerificationLog verificationLog) {
//         VerificationLog savedLog = verificationLogService.createLog(verificationLog);
//         return ResponseEntity.ok(savedLog);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.VerificationLog;
import com.example.demo.service.VerificationLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verification-logs")
public class VerificationLogController {

    private final VerificationLogService service;

    public VerificationLogController(VerificationLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VerificationLog> create(@RequestBody VerificationLog log) {
        return ResponseEntity.ok(service.createLog(log));
    }
}
