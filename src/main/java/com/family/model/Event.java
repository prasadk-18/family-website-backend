package com.family.model;

import jakarta.persistence.*;

@Entity
public class Event {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String name;
 private String eventDate;
 private String eventTime;
 private String venue;

 @Column(length = 1000)
 private String additionalInfo;

 public Event(){}

 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}

 public String getName(){return name;}
 public void setName(String name){this.name=name;}

 public String getEventDate(){return eventDate;}
 public void setEventDate(String eventDate){this.eventDate=eventDate;}

 public String getEventTime(){return eventTime;}
 public void setEventTime(String eventTime){this.eventTime=eventTime;}

 public String getVenue(){return venue;}
 public void setVenue(String venue){this.venue=venue;}

 public String getAdditionalInfo(){return additionalInfo;}
 public void setAdditionalInfo(String additionalInfo){this.additionalInfo=additionalInfo;}
}