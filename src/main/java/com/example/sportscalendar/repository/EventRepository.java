package com.example.sportscalendar.repository;

import com.example.sportscalendar.model.Event;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @EntityGraph(attributePaths = {"sport", "venue", "homeTeam", "awayTeam"})
    List<Event> findAll();
}
