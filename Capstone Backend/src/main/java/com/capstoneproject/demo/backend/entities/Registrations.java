package com.capstoneproject.demo.backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Registrations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "User ID is required")
	private Long id;
	private String eventId;
	private String name;
	private String email;
	private LocalDateTime regDate;	
	private Long userId;

	public Registrations() {
		super();
	}

	public Registrations(@NotNull(message = "User ID is required") Long id, String eventId, String name, String email,
			LocalDateTime regDate, Long userId) {
		super();
		this.id = id;
		this.eventId = eventId;
		this.name = name;
		this.email = email;
		this.regDate = regDate;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Registrations [id=" + id + ", eventId=" + eventId + ", name=" + name + ", email=" + email + ", regDate="
				+ regDate + ", userId=" + userId + "]";
	}
	
	
}