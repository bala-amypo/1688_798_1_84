package com.example.demo.repository;

import com.example.demo.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GarageRepository extends JpaRepository<Garage, Long> {
    Optional<Garage> findByGarageName(String garageName);
}
