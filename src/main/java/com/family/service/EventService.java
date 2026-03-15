package com.family.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.model.Event;
import com.family.repository.EventRepository;

@Service
public class EventService {

 @Autowired
 EventRepository repo;

 public List<Event> getEvents(){
  return repo.findAll();
 }

 public Event saveEvent(Event e){
  return repo.save(e);
 }
}