package com.example.sportscalendar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;

    private LocalDateTime date_time;

    @ManyToOne
    @JoinColumn(name = "_sport_id", nullable = false)
    private Sport sport;

    @ManyToOne
    @JoinColumn(name = "_venue_id", nullable = false)
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "_home_team_id", nullable = false)
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "_away_team_id", nullable = false)
    private Team awayTeam;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Constructors, Getters, and Setters are handled by Lombok
}
