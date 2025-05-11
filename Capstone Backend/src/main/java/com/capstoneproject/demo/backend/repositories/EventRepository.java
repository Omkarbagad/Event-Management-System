package com.capstoneproject.demo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.demo.backend.entities.Events;

public interface EventRepository extends JpaRepository<Events, Long> {

}
