package com.example.sportscalendar.controller;

import com.example.sportscalendar.dto.EventDTO;
import com.example.sportscalendar.model.Event;
import com.example.sportscalendar.model.Sport;
import com.example.sportscalendar.model.Team;
import com.example.sportscalendar.model.Venue;
import com.example.sportscalendar.repository.EventRepository;
import com.example.sportscalendar.repository.SportRepository;
import com.example.sportscalendar.repository.TeamRepository;
import com.example.sportscalendar.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private VenueRepository venueRepository;

    // Get all events
    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get one event
    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new event
    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody EventDTO eventDTO) {
        // Fetch related entities
        Optional<Sport> sportOpt = sportRepository.findById(eventDTO.getSport_id());
        Optional<Venue> venueOpt = venueRepository.findById(eventDTO.getVenue_id());
        Optional<Team> homeTeamOpt = teamRepository.findById(eventDTO.getHome_team_id());
        Optional<Team> awayTeamOpt = teamRepository.findById(eventDTO.getAway_team_id());

        if (sportOpt.isPresent() && venueOpt.isPresent() && homeTeamOpt.isPresent() && awayTeamOpt.isPresent()) {
            Event event = new Event();
            event.setDate_time(eventDTO.getDate_time());
            event.setSport(sportOpt.get());
            event.setVenue(venueOpt.get());
            event.setHomeTeam(homeTeamOpt.get());
            event.setAwayTeam(awayTeamOpt.get());
            event.setDescription(eventDTO.getDescription());

            Event savedEvent = eventRepository.save(event);
            return ResponseEntity.ok(savedEvent);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
