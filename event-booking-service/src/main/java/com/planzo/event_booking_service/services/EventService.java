package com.planzo.event_booking_service.services;

import com.planzo.event_booking_service.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface EventService {

  List<Map<String, Object>> getAllEvents(String category, String location);

  Map<String, Object> getEventDetails(String eventId) throws ResourceNotFoundException;

}
