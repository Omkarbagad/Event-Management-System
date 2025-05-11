package com.capstoneproject.demo.backend.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capstoneproject.demo.backend.entities.Events;
import com.capstoneproject.demo.backend.services.EventService;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/events")
public class EventController {
	private EventService eventService;

	@Autowired
	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}

	@GetMapping
	public ResponseEntity<List<Events>> getAllEvents() {
		List<Events> events = eventService.getAllEvents();
		return ResponseEntity.status(HttpStatus.OK).body(events);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Events> getEvents(@PathVariable Long id) {
		Events Events = eventService.getEventById(id);
		return ResponseEntity.status(HttpStatus.OK).body(Events);
	}

	@PostMapping
	public ResponseEntity<?> createEvents(@RequestBody Events event) {
		Events saved = eventService.createEvent(event);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/events/" + saved.getId()))
				.body(saved);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Events> updateEvents(@PathVariable Long id, @RequestBody Events newEvent) {
		Events updated = eventService.updateEvent(id, newEvent);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Events> patchEvents(@PathVariable Long id, @RequestBody Events patch) {
		Events updated = eventService.patchEvent(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvents(@PathVariable Long id) {
		eventService.deleteEvents(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
