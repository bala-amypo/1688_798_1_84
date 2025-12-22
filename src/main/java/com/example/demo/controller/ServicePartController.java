@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private final ServicePartService service;

    public ServicePartController(ServicePartService service) {
        this.service = service;
    }

    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        return service.createPart(part);
    }
}
