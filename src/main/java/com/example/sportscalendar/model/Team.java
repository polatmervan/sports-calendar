package com.example.sportscalendar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Team")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "_sport_id", nullable = false)
    private Sport sport;

    // Constructors, Getters, and Setters are handled by Lombok
}
