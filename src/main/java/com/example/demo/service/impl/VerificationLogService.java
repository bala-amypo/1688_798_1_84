@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository logRepo;
    private final ServiceEntryRepository entryRepo;

    public VerificationLogServiceImpl(VerificationLogRepository logRepo,
                                      ServiceEntryRepository entryRepo) {
        this.logRepo = logRepo;
        this.entryRepo = entryRepo;
    }

    @Override
    public VerificationLog createLog(VerificationLog log) {

        ServiceEntry entry = entryRepo.findById(log.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        log.setServiceEntry(entry);
        log.setVerifiedAt(java.time.LocalDateTime.now());

        return logRepo.save(log);
    }
}
