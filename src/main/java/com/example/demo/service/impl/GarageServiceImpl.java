// package com.example.demo.service.impl;

// import com.example.demo.model.Garage;
// import com.example.demo.repository.GarageRepository;
// import com.example.demo.service.GarageService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class GarageServiceImpl implements GarageService {
    
//     @Autowired
//     private GarageRepository garageRepository;

//     @Override
//     public Garage createGarage(Garage garage) {
//         if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
//             throw new IllegalArgumentException("Garage already exists");
//         }
//         return garageRepository.save(garage);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("Garage already exists");
        }
        garage.setActive(true);
        return garageRepository.save(garage);
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));
    }
}
