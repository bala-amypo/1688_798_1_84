package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(
            com.example.demo.model.Vehicle vehicle
    );

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // ✅ CORRECT replacement
    List<ServiceEntry> findByGarage_IdAndOdometerReadingGreaterThan(
            Long garageId,
            Integer odometerReading
    );
}
