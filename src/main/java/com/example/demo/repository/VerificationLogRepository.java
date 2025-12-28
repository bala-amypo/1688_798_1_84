// package com.example.demo.repository;

// import com.example.demo.model.VerificationLog;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {
// }

package com.example.demo.repository;

import com.example.demo.entity.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationLogRepository extends JpaRepository<ServiceEntry, Long> {
    // Repository methods
}

