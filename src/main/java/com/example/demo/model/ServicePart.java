// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "service_parts")
// public class ServicePart {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "service_entry_id", nullable = false)
//     private ServiceEntry serviceEntry;
    
//     @Column(nullable = false)
//     private String partName;
    
//     @Column(nullable = false)
//     private Integer quantity;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
    
//     public ServiceEntry getServiceEntry() { return serviceEntry; }
//     public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }
    
//     public String getPartName() { return partName; }
//     public void setPartName(String partName) { this.partName = partName; }
    
//     public Integer getQuantity() { return quantity; }
//     public void setQuantity(Integer quantity) { this.quantity = quantity; }
// }

package com.example.demo.model; // or wherever this class resides

import com.example.demo.model.ServiceEntry;

public class ServicePart {
    // your class definition that uses ServiceEntry

    private ServiceEntry serviceEntry;

    // getters, setters, etc.
}
