package gianmarte.u5w1d5.repositories;

import gianmarte.u5w1d5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    boolean existsByName(String name);
}
