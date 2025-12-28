// package com.example.demo.repository;

// import com.example.demo.model.Garage;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import java.util.Optional;

// @Repository
// public interface GarageRepository extends JpaRepository<Garage, Long> {
//     Optional<Garage> findByGarageName(String garageName);
// }

package com.example.demo.repository;

import com.example.demo.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GarageRepository extends JpaRepository<Garage, Long> {

    Optional<Garage> findByGarageName(String garageName);

    boolean existsByGarageName(String garageName);
}
