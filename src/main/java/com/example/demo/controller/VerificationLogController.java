@RestController
@RequestMapping("/verification-logs")
public class VerificationLogController {

    private final VerificationLogService service;

    public VerificationLogController(VerificationLogService service) {
        this.service = service;
    }

    @PostMapping
    public VerificationLog create(@RequestBody VerificationLog log) {
        return service.createLog(log);
    }
}
