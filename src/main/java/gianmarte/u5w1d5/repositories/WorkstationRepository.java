package gianmarte.u5w1d5.repositories;

import gianmarte.u5w1d5.entities.Building;
import gianmarte.u5w1d5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

    boolean existsByBuildingAndDescription(Building building, String description);
}
