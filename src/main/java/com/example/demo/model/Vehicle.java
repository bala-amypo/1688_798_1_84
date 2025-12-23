@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private String model;
    private String vin;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;   // 🔴 REQUIRED

    // getters & setters
    public Long getId() {
        return id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
