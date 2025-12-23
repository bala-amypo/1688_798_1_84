package com.example.demo.repository;

import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByVin(String vin);

    // 🔥 IMPORTANT: owner is an entity
    List<Vehicle> findByOwner_Id(Long ownerId);
}
 