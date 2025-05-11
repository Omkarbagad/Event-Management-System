package com.capstoneproject.demo.backend.services;

import java.util.List;

import com.capstoneproject.demo.backend.entities.Events;

public interface EventService {
	List<Events> getAllEvents();

	Events getEventById(Long id);

	Events createEvent(Events event);

	Events updateEvent(Long id, Events event);

	Events patchEvent(Long id, Events event);

	void deleteEvents(Long id);

}
