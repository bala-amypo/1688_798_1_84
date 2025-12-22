@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository partRepo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(ServicePartRepository partRepo,
                                  ServiceEntryRepository entryRepo) {
        this.partRepo = partRepo;
        this.entryRepo = entryRepo;
    }

    @Override
    public ServicePart createPart(ServicePart part) {

        ServiceEntry entry = entryRepo.findById(part.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        if (part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        part.setServiceEntry(entry);
        return partRepo.save(part);
    }
}
