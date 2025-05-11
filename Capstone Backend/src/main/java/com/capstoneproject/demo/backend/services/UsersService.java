package com.capstoneproject.demo.backend.services;

import java.util.List;

import com.capstoneproject.demo.backend.entities.Users;

public interface UsersService {
	List<Users> getAllUsers();

	Users getUserById(Long id);

	Users createUser(Users user);

	Users updateUser(Long id, Users user);

	Users patchUser(Long id, Users user);

	void deleteUser(Long id);

}
