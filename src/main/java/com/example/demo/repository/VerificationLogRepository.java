// package com.example.demo.repository;

// import com.example.demo.model.VerificationLog;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {
// }

package com.example.demo.repository;

import com.example.demo.model.VerificationLog;
import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {

    List<VerificationLog> findByServiceEntry(ServiceEntry serviceEntry);
}
