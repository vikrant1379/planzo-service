package com.planzo.event_booking_service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "events")
public class EventEntity {

  @Id
  @Field("_id")
  private String id;

  @Field("event_id")
  @Indexed(unique = true)
  private String eventId;

  @Field("event_name")
  private String eventName;

  private String description;
  private String category;
  private String location;
  private String date;
  private String price;
}

