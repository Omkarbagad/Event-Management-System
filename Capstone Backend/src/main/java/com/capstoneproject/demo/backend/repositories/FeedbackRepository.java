package com.capstoneproject.demo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.demo.backend.entities.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
