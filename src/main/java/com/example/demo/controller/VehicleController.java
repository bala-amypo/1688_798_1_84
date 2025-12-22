@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle v) {
        return service.createVehicle(v);
    }

    @GetMapping("/{id}")
    public Vehicle get(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> byOwner(@PathVariable Long ownerId) {
        return service.getVehiclesByOwner(ownerId);
    }

    @PostMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateVehicle(id);
    }
}
    