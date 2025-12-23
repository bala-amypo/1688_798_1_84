package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "service_entries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Vehicle vehicle;

    @ManyToOne(optional = false)
    private Garage garage;

    private String serviceType;
    private LocalDate serviceDate;
    private Integer odometerReading;
    private String description;

    @CreationTimestamp
    private Timestamp recordedAt;
}
