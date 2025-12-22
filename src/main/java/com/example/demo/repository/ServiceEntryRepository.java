public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);
    List<ServiceEntry> findByVehicleId(Long vehicleId);
}
