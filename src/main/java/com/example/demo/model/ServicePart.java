package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "service_parts")
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ServiceEntry serviceEntry;

    private String partName;
    private Integer quantity;

    public ServicePart() {}

    public ServicePart(ServiceEntry serviceEntry, String partName, Integer quantity) {
        this.serviceEntry = serviceEntry;
        this.partName = partName;
        this.quantity = quantity;
    }

    
}
