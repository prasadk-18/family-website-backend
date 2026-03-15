package com.family.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.family.model.Event;

public interface EventRepository extends JpaRepository<Event,Long>{
}