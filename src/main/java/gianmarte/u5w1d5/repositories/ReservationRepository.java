package gianmarte.u5w1d5.repositories;

import gianmarte.u5w1d5.entities.Reservation;
import gianmarte.u5w1d5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByUserAndDate(User user, LocalDate date);
}
