package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "garages", uniqueConstraints = @UniqueConstraint(columnNames = "garageName"))
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String garageName;
    private String address;
    private Boolean active;

    @OneToMany(mappedBy = "garage")
    private List<ServiceEntry> serviceEntries;

    public Garage() {}

    public Garage(String garageName, String address, Boolean active) {
        this.garageName = garageName;
        this.address = address;
        this.active = active;
    }

    // getters & setters
}
    