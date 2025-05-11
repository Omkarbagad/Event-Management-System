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
import com.capstoneproject.demo.backend.entities.Feedback;
import com.capstoneproject.demo.backend.services.FeedbackService;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/feedbacks")
public class FeedbackController {
	private FeedbackService feedbackService;
	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}

	@GetMapping
	public ResponseEntity<List<Feedback>> getAllEvents() {
		List<Feedback> events = feedbackService.getAllFeedback();
		return ResponseEntity.status(HttpStatus.OK).body(events);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Feedback> getEvents(@PathVariable Long id) {
		Feedback Events = feedbackService.getFeedbackById(id);
		return ResponseEntity.status(HttpStatus.OK).body(Events);
	}

	@PostMapping
	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback Events) {
		Feedback saved = feedbackService.createFeedback(Events);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/events/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback newEvent) {
		Feedback updated = feedbackService.updateFeedback(id, newEvent);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Feedback> patchFeedback(@PathVariable Long id, @RequestBody Feedback patch) {
		Feedback updated = feedbackService.patchFeedback(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvents(@PathVariable Long id) {
		feedbackService.deleteFeedback(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
