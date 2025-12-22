package com.example.demo.service;

import com.example.demo.model.Garage;
import java.util.List;

public interface GarageService {

    Garage saveGarage(Garage garage);

    Garage getGarageById(Long id);

    List<Garage> getAllGarages();
}
