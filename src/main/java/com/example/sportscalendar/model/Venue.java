package com.example.sportscalendar.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Venue")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int venue_id;

    private String name;
    private String address;
    private Integer capacity;

    // Constructors, Getters, and Setters are handled by Lombok
}
