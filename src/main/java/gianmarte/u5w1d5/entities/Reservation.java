package gianmarte.u5w1d5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reservationId;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;

  public Reservation(LocalDate date, User user, Workstation workstation) {
    this.date = date;
    this.user = user;
    this.workstation = workstation;
}}
