package com.planzo.event_booking_service.repository;


import com.planzo.event_booking_service.entities.EventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<EventEntity, String> {
  List<EventEntity> findByCategoryAndLocation(String category, String location);
  List<EventEntity> findByCategory(String category);
  List<EventEntity> findByLocation(String location);
  Optional<EventEntity> findByEventId(String eventId);
}
