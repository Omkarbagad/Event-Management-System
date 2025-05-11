package com.capstoneproject.demo.backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String password;

	private String number;
	
	private String usertype;

	public Users() {
		super();
	}

	public Users(@NotNull(message = "User ID is required") Long id, String name, String email, String password,
			String number, String usertype) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.number = number;
		this.usertype = usertype;
	}

	public Long getId() {
		return id;
	}

	public void setUserId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "Users [userId=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", number=" + number + ", usertype=" + usertype + "]";
	}
	
	
	
	
}