package gianmarte.u5w1d5.repositories;

import gianmarte.u5w1d5.entities.Reservation;
import gianmarte.u5w1d5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByDateAndWorkstation(LocalDate date, Workstation workstation);
}
