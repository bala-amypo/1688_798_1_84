package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "garages", uniqueConstraints = @UniqueConstraint(columnNames = "garageName"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String garageName;

    private String address;
    private String contactNumber;

    private Boolean active = true;
}
