package com.example.demo.repository;

import com.example.demo.entity.ServicePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicePartRepository extends JpaRepository<ServicePart, Long> {
    List<ServicePart> findByServiceEntryId(Long entryId);
}
