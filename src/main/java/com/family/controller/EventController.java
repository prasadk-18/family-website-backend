package com.family.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.family.model.Event;
import com.family.service.EventService;

@RestController
@CrossOrigin
@RequestMapping("/events")
public class EventController {

 @Autowired
 EventService service;

 @GetMapping
 public List<Event> getEvents(){
  return service.getEvents();
 }

 @PostMapping
 public Event addEvent(@RequestBody Event event){
  return service.saveEvent(event);
 }
}