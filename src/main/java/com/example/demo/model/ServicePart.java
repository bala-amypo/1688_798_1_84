package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "service_parts")
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ServiceEntry serviceEntry;

    private String partName;
    private String partNumber;
    private BigDecimal cost;
    private Integer quantity;

    public ServicePart() {}

    public Long getId() { return id; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
