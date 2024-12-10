package com.planzo.event_booking_service.services.impl;

import com.planzo.event_booking_service.entities.EventEntity;
import com.planzo.event_booking_service.exceptions.ResourceNotFoundException;
import com.planzo.event_booking_service.repository.EventRepository;
import com.planzo.event_booking_service.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventServiceImpl implements EventService {

  private final EventRepository eventRepository;

  @Autowired
  public EventServiceImpl(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  @Override
  public List<Map<String, Object>> getAllEvents(String category, String location) {
    List<EventEntity> events;

    if (category != null && location != null) {
      events = eventRepository.findByCategoryAndLocation(category, location);
    } else if (category != null) {
      events = eventRepository.findByCategory(category);
    } else if (location != null) {
      events = eventRepository.findByLocation(location);
    } else {
      events = eventRepository.findAll();
    }

    return events.stream()
        .map(event -> {
          Map<String, Object> eventMap = new HashMap<>();
          eventMap.put("eventId", event.getEventId());
          eventMap.put("name", event.getEventName());
          eventMap.put("category", event.getCategory());
          eventMap.put("location", event.getLocation());
          eventMap.put("date", event.getDate());
          eventMap.put("price", event.getPrice());
          return eventMap;
        })
        .toList();
  }

  @Override
  public Map<String, Object> getEventDetails(String eventId) throws ResourceNotFoundException {
    EventEntity event = eventRepository.findByEventId(eventId)
        .orElseThrow(() -> new ResourceNotFoundException("Event not found with event Id: " + eventId));

    return Map.of(
        "eventId", event.getEventId(),
        "name", event.getEventName(), // Ensure this matches your getter in EventEntity
        "description", event.getDescription(),
        "category", event.getCategory(),
        "location", event.getLocation(),
        "date", event.getDate(),
        "price", event.getPrice()
    );
  }
}

