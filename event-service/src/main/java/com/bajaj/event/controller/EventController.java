package com.bajaj.event.controller;

import com.bajaj.event.entity.Event;
import com.bajaj.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository repository;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return repository.save(event);
    }

    @GetMapping
    @Cacheable(value = "events")
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "events", key = "#id")
    public Event getEvent(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }
}
