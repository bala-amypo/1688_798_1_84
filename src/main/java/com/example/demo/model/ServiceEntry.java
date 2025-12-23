package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceType;
    private Double cost;
    private LocalDate serviceDate;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;   // 🔴 THIS WAS MISSING

    // getters and setters
}
