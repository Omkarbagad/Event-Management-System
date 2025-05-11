package com.capstoneproject.demo.backend.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate date;
	private LocalTime time;
	private String location;
	private String description;
	private String category;
	private Long organizerId;

	public Events() {
		super();
	}

	public Events(Long id, String name, LocalDate date, LocalTime time, String location, String description,
			String category, Long organizerId) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.location = location;
		this.description = description;
		this.category = category;
		this.organizerId = organizerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerID(Long organizerId) {
		this.organizerId = organizerId;
	}

	@Override
	public String toString() {
		return "Events [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + ", location=" + location
				+ ", description=" + description + ", category=" + category + ", organizerID=" + organizerId + "]";
	}
	
	

}
