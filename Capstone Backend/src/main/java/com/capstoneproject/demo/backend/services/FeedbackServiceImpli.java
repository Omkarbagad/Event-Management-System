package com.capstoneproject.demo.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.demo.backend.entities.Feedback;
import com.capstoneproject.demo.backend.exceptions.EventNotFoundException;
import com.capstoneproject.demo.backend.exceptions.FeedbackNotFoundException;
import com.capstoneproject.demo.backend.repositories.FeedbackRepository;

import jakarta.validation.Valid;
@Service
public class FeedbackServiceImpli implements FeedbackService {

	private final FeedbackRepository feedbackRepository;

	@Autowired
	public FeedbackServiceImpli(FeedbackRepository feedRepository) {
		this.feedbackRepository = feedRepository;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback getFeedbackById(Long id) {
		return feedbackRepository.findById(id)
				.orElseThrow(() -> new FeedbackNotFoundException("Event not found with ID: " + id));
	}

	@Override
	public Feedback createFeedback(@Valid Feedback event) {
		return feedbackRepository.save(event);
	}

	@Override
	public Feedback updateFeedback(Long id, @Valid Feedback updated) {
		Feedback existing = feedbackRepository.findById(id)
				.orElseThrow(() -> new FeedbackNotFoundException("Event not found with ID: " + id));
		existing.setEvent(updated.getEvent());
		existing.setRating((int) updated.getRating());
		existing.setFeedback(updated.getFeedback());
		return feedbackRepository.save(existing);
	}

	@Override
	public Feedback patchFeedback(Long id, Feedback patch) {
		Feedback existing = feedbackRepository.findById(id)
				.orElseThrow(() -> new FeedbackNotFoundException("Event not found with ID: " + id));

		if (patch.getEvent() != null) {
			existing.setEvent(patch.getEvent());
		}
		if (patch.getRating() != null) {
			existing.setRating((int) patch.getRating());
		}
		if (patch.getFeedback() != null) {
			existing.setFeedback(patch.getFeedback());
		}
		return feedbackRepository.save(existing);
	}

	@Override
	public void deleteFeedback(Long id) {
		if (!feedbackRepository.existsById(id)) {
			throw new FeedbackNotFoundException("Cannot delete. Event not found with ID: " + id);
		}
		feedbackRepository.deleteById(id);
	}
}
