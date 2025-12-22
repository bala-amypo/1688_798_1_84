package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partName;
    private int quantity;

    @ManyToOne
    private ServiceEntry serviceEntry;

    public Long getId() {
        return id;
    }

    public String getPartName() {
        return partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public ServiceEntry getServiceEntry() {
        return serviceEntry;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setServiceEntry(ServiceEntry serviceEntry) {
        this.serviceEntry = serviceEntry;
    }
}
