package gianmarte.u5w1d5.services;

import gianmarte.u5w1d5.entities.Reservation;
import gianmarte.u5w1d5.exceptions.ValidationException;
import gianmarte.u5w1d5.repositories.ReservationRepository;
import gianmarte.u5w1d5.repositories.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final WorkstationRepository workstationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, WorkstationRepository workstationRepository) {
        this.reservationRepository = reservationRepository;
        this.workstationRepository = workstationRepository;
    }

    public void saveReservation(Reservation reservation) {
        if (reservationRepository.existsByUserAndDate(reservation.getUser(), reservation.getDate())) {
            throw new ValidationException("L'utente ha già una prenotazione per la data");
        }
        this.reservationRepository.save(reservation);
    }
}
