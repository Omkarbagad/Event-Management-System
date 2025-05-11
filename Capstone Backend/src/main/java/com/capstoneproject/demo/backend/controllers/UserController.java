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
import com.capstoneproject.demo.backend.entities.Users;
import com.capstoneproject.demo.backend.services.UsersService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
	private UsersService usersService;

	@Autowired
	public UserController(UsersService usersService) {
		this.usersService = usersService;
	}

	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = usersService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> getUsers(@PathVariable Long id) {
		Users users = usersService.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@PostMapping
	public ResponseEntity<Users> createUsers(@RequestBody Users users) {
		Users saved = usersService.createUser(users);
		return ResponseEntity.status(HttpStatus.CREATED).location(URI.create("/api/users/" + saved.getId()))
				.body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users newUser) {
		Users updated = usersService.updateUser(id, newUser);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Users> patchUsers(@PathVariable Long id, @RequestBody Users patch) {
		Users updated = usersService.patchUser(id, patch);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsers(@PathVariable Long id) {
		usersService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}

