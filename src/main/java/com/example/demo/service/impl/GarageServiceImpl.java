package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;

public class GarageServiceImpl {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public Garage createGarage(Garage garage) {
        garageRepository.findByGarageName(garage.getGarageName())
                .ifPresent(g -> {
                    throw new IllegalArgumentException("Garage already exists");
                });
        return garageRepository.save(garage);
    }
}
