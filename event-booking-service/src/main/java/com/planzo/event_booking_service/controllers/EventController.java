package com.planzo.event_booking_service.controllers;

import com.planzo.event_booking_service.exceptions.ResourceNotFoundException;
import com.planzo.event_booking_service.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

  private final EventService eventService;

  // Constructor-based dependency injection
  @Autowired
  public EventController(EventService eventService) {
    this.eventService = eventService;
  }

  // List all available events
  @GetMapping
  public List<Map<String, Object>> getAllEvents(
      @RequestParam(required = false) String category,
      @RequestParam(required = false) String location) {
    return eventService.getAllEvents(category, location);
  }

  // Get details of a specific event
  @GetMapping("/{event-id}")
  public Map<String, Object> getEventDetails(@PathVariable(name = "event-id") String eventId) throws ResourceNotFoundException {
    return eventService.getEventDetails(eventId);
  }
}

