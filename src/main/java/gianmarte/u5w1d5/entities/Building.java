package gianmarte.u5w1d5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long buildingId;
    private String name;
    private String address;
    private String city;

    public Building(String name, String address, String city) {
    this.name = name;
    this.address = address;
    this.city = city;
}
}
