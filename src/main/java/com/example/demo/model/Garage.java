package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
        mappedBy = "garage",   // MUST MATCH ServiceEntry field
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<ServiceEntry> serviceEntries;

    // getters and setters
}
