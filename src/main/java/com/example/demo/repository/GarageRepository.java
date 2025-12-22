public interface GarageRepository extends JpaRepository<Garage, Long> {
    Optional<Garage> findByGarageName(String garageName);
}
