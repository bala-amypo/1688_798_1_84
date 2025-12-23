package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // Optional advanced queries (as per spec)
    List<ServiceEntry> findByGarageAndMinOdometer(Long garageId, int minOdometer);

    List<ServiceEntry> findByVehicleAndDateRange(Long vehicleId, LocalDate from, LocalDate to);
}
