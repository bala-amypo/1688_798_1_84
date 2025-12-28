// package com.example.demo.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class HealthController {

//     @GetMapping("/")
//     public String home() {
//         return "Application is running!";
//     }

//     @GetMapping("/health")
//     public String health() {
//         return "OK";
//     }
// }
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("OK");
    }
}
