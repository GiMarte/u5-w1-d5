package gianmarte.u5w1d5.entities;

import gianmarte.u5w1d5.enums.WorkstationType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "workstations")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workstationId;
    private String description;

    @Enumerated(EnumType.STRING)
    private WorkstationType workstationType;

    private int maxPeople;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Workstation( String description, WorkstationType workstationType, int maxPeople, Building building) {
        this.description = description;
        this.workstationType = workstationType;
        this.maxPeople = maxPeople;
        this.building = building;
}}
