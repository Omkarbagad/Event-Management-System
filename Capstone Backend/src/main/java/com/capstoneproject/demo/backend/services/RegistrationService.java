package com.capstoneproject.demo.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstoneproject.demo.backend.entities.Registrations;
@Service
public interface RegistrationService {
	List<Registrations> getAllRegistrations();

	Registrations getRegistrationById(Long id);

	Registrations createRegistration(Registrations reg);

	Registrations updateRegistration(Long id, Registrations reg);

	Registrations patchRegistration(Long id, Registrations event);

	void deleteRegistration(Long id);

}
