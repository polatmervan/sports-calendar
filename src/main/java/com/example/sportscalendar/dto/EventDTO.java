package com.example.sportscalendar.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EventDTO {

    private LocalDateTime date_time;
    private int sport_id;
    private int venue_id;
    private int home_team_id;
    private int away_team_id;
    private String description;

    // Getters and Setters are handled by Lombok
}
