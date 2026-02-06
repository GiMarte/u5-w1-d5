package gianmarte.u5w1d5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String name;
    private String surname;
    private String email;

    public User(String email, String surname, String name, String username) {
    this.email = email;
    this.surname = surname;
    this.name = name;
    this.username = username;
}
}
