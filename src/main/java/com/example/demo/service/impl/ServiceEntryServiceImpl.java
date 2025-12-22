@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository entryRepo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository entryRepo,
                                   VehicleRepository vehicleRepo,
                                   GarageRepository garageRepo) {
        this.entryRepo = entryRepo;
        this.vehicleRepo = vehicleRepo;
        this.garageRepo = garageRepo;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        Vehicle vehicle = vehicleRepo.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        Garage garage = garageRepo.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        if (!vehicle.getActive()) {
            throw new IllegalArgumentException("Only active vehicles allowed");
        }

        if (entry.getServiceDate().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("future service date");
        }

        entryRepo.findTopByVehicleOrderByOdometerReadingDesc(vehicle)
                .ifPresent(last -> {
                    if (entry.getOdometerReading() < last.getOdometerReading()) {
                        throw new IllegalArgumentException("Odometer must be >=");
                    }
                });

        entry.setVehicle(vehicle);
        entry.setGarage(garage);
        return entryRepo.save(entry);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return entryRepo.findByVehicleId(vehicleId);
    }
}
