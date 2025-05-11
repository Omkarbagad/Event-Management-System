package com.capstoneproject.demo.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.demo.backend.entities.Events;
import com.capstoneproject.demo.backend.exceptions.EventNotFoundException;
import com.capstoneproject.demo.backend.repositories.EventRepository;

import jakarta.validation.Valid;

@Service
public class EventServiceImpl implements EventService {

	private final EventRepository eventRepository;

	@Autowired
	public EventServiceImpl(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public List<Events> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Events getEventById(Long id) {
		return eventRepository.findById(id)
				.orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + id));
	}

	@Override
	public Events createEvent(@Valid Events event) {
		return eventRepository.save(event);
	}

	@Override
	public Events updateEvent(Long id, @Valid Events updated) {
		Events existing = eventRepository.findById(id)
				.orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + id));
		existing.setName(updated.getName());
		existing.setDate(updated.getDate());
		existing.setTime(updated.getTime());
		existing.setLocation(updated.getLocation());
		existing.setDescription(updated.getDescription());
		existing.setCategory(updated.getCategory());
		return eventRepository.save(existing);
	}

	@Override
	public Events patchEvent(Long id, Events patch) {
		Events existing = eventRepository.findById(id)
				.orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + id));

		if (patch.getName() != null) {
			existing.setName(patch.getName());
		}
		if (patch.getDate() != null) {
			existing.setDate(patch.getDate());
		}
		if (patch.getTime() != null) {
			existing.setTime(patch.getTime());
		}
		if (patch.getLocation() != null) {
			existing.setLocation(patch.getLocation());
		}
		if (patch.getDescription() != null) {
			existing.setDescription(patch.getDescription());
		}
		if (patch.getCategory() != null) {
			existing.setCategory(patch.getCategory());
		}
		return eventRepository.save(existing);
	}

	@Override
	public void deleteEvents(Long id) {
		if (!eventRepository.existsById(id)) {
			throw new EventNotFoundException("Cannot delete. Event not found with ID: " + id);
		}
		eventRepository.deleteById(id);
	}

}
