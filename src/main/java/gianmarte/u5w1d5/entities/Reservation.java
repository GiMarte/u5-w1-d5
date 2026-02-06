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
    private User userId;

    @OneToMany
    private long workstation;

    public Reservation(long workstation, User userId, LocalDate date) {
    this.workstation = workstation;
    this.userId = userId;
    this.date = date;
}
}
