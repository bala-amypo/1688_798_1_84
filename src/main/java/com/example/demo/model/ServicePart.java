package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "service_parts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private ServiceEntry serviceEntry;

    private String partName;
    private String partNumber;
    private BigDecimal cost;
    private Integer quantity;
}
