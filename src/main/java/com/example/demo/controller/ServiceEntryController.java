@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {

    private final ServiceEntryService service;

    public ServiceEntryController(ServiceEntryService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceEntry create(@RequestBody ServiceEntry entry) {
        return service.createServiceEntry(entry);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> list(@PathVariable Long vehicleId) {
        return service.getEntriesForVehicle(vehicleId);
    }
}
