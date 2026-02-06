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
    private long id;
    private LocalDate date;

    @ManyToOne
    private User user;

    @OneToMany
    private long workstation;

    public Reservation(long workstation, User user, LocalDate date) {
    this.workstation = workstation;
    this.user = user;
    this.date = date;
}
}
