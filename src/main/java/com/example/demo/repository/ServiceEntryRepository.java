package com.example.demo.repository;

import com.example.demo.entity.ServiceEntry;
import com.example.demo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    List<ServiceEntry> findByVehicleId(Long vehicleId);
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);
}
