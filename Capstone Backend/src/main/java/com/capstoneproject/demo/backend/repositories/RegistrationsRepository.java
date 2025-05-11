package com.capstoneproject.demo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.demo.backend.entities.Registrations;

public interface RegistrationsRepository extends JpaRepository<Registrations, Long> {

}
