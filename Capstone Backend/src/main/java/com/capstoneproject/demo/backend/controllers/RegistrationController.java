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

import com.capstoneproject.demo.backend.entities.Registrations;
import com.capstoneproject.demo.backend.services.RegistrationService;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/registrations")
public class RegistrationController {
	private RegistrationService regService;

	@Autowired
	public RegistrationController(RegistrationService regService) {
		this.regService = regService;
	}

	@GetMapping
	public ResponseEntity<List<Registrations>> getAllRegistrations() {
		List<Registrations> registrations = regService.getAllRegistrations();
		return ResponseEntity.status(HttpStatus.OK).body(registrations);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Registrations> getRegistrations(@PathVariable Long id) {
		Registrations registrations = regService.getRegistrationById(id);
		return ResponseEntity.status(HttpStatus.OK).body(registrations);
	}

	@PostMapping
	public ResponseEntity<Registrations> createRegistrations(@RequestBody Registrations registrations) {
		Registrations saved = regService.createRegistration(registrations);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/registrations/" + saved.getUserId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Registrations> updateRegistrations(@PathVariable Long id, @RequestBody Registrations newReg) {
		Registrations updated = regService.updateRegistration(id, newReg);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Registrations> patchRegistrations(@PathVariable Long id, @RequestBody Registrations patch) {
		Registrations updated = regService.patchRegistration(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteRegistrations(@PathVariable Long id) {
		regService.deleteRegistration(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
