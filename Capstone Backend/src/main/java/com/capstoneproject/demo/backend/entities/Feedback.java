package com.capstoneproject.demo.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userid;
	private String username;
	private String email;
	private String event;
	private int rating;
	private String feedback;
	
	public Feedback() {
		
	}

	public Feedback(Long id, String userid, String username, String email, String event, int rating,
			String feedback) {
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.event = event;
		this.rating = rating;
		this.feedback = feedback;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Number getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userid=" + userid + ", username=" + username + ", email=" + email + ", event="
				+ event + ", rating=" + rating + ", feedback=" + feedback + "]";
	}
	
	
}
