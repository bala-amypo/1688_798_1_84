package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    @Query("""
        SELECT s FROM ServiceEntry s
        WHERE s.garage.id = :garageId AND s.odometer >= :minOdometer
    """)
    List<ServiceEntry> findByGarageAndMinOdometer(
            @Param("garageId") long garageId,
            @Param("minOdometer") int minOdometer
    );

    @Query("""
        SELECT s FROM ServiceEntry s
        WHERE s.vehicle.id = :vehicleId
        AND s.serviceDate BETWEEN :start AND :end
    """)
    List<ServiceEntry> findByVehicleAndDateRange(
            @Param("vehicleId") long vehicleId,
            @Param("start") LocalDate start,
            @Param("end") LocalDate end
    );
}
