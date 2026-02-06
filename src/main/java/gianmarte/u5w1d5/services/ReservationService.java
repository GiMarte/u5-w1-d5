package gianmarte.u5w1d5.services;

import gianmarte.u5w1d5.entities.Reservation;
import gianmarte.u5w1d5.repositories.ReservationRepository;

public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.existsByDateAndWorkstation()
    }
}
