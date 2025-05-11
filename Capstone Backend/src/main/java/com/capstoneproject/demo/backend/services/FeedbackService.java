package com.capstoneproject.demo.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstoneproject.demo.backend.entities.Feedback;
@Service
public interface FeedbackService {
	List<Feedback> getAllFeedback();

	Feedback getFeedbackById(Long id);

	Feedback createFeedback(Feedback event);

	Feedback updateFeedback(Long id, Feedback event);

	Feedback patchFeedback(Long id, Feedback event);

	void deleteFeedback(Long id);
}
