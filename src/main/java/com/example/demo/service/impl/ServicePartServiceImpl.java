// package com.example.demo.service.impl;

// import com.example.demo.model.ServicePart;
// import com.example.demo.repository.ServicePartRepository;
// import com.example.demo.repository.ServiceEntryRepository;
// import com.example.demo.service.ServicePartService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class ServicePartServiceImpl implements ServicePartService {
    
//     @Autowired
//     private ServicePartRepository servicePartRepository;
    
//     @Autowired
//     private ServiceEntryRepository serviceEntryRepository;

//     @Override
//     public ServicePart createPart(ServicePart servicePart) {
//         if (servicePart.getQuantity() <= 0) {
//             throw new IllegalArgumentException("Quantity must be positive");
//         }
        
//         serviceEntryRepository.findById(servicePart.getServiceEntry().getId())
//                 .orElseThrow(() -> new IllegalArgumentException("Service entry not found"));
        
//         return servicePartRepository.save(servicePart);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.ServiceEntry;
import com.example.demo.service.ServicePartService;

public class ServicePartServiceImpl implements ServicePartService {
    // Use ServiceEntry here correctly
}
