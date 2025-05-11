package com.capstoneproject.demo.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstoneproject.demo.backend.entities.Users;
import com.capstoneproject.demo.backend.exceptions.UserNotFoundException;
import com.capstoneproject.demo.backend.repositories.UsersRepository;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UsersService {

	private final UsersRepository usersRepository;

	@Autowired
	public UserServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Users getUserById(Long id) {
		return usersRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
	}

	@Override
	public Users createUser(@Valid Users user) {
		return usersRepository.save(user);
	}

	@Override
	public Users updateUser(Long id, Users updated) {
		Users existing = usersRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
		existing.setName(updated.getName());
		existing.setEmail(updated.getEmail());
		existing.setPassword(updated.getPassword());
		existing.setNumber(updated.getNumber());
		existing.setUsertype(updated.getUsertype());
		return usersRepository.save(existing);
	}

	@Override
	public Users patchUser(Long id, Users patch) {
		Users existing = usersRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

		if (patch.getName() != null) {
			existing.setName(patch.getName());
		}
		if (patch.getEmail() != null) {
			existing.setEmail(patch.getEmail());
		}
		if (patch.getPassword() != null) {
			existing.setPassword(patch.getPassword());
		}
		if (patch.getNumber() != null) {
			existing.setNumber(patch.getNumber());
		}
		if (patch.getUsertype() != null) {
			existing.setUsertype(patch.getUsertype());
		}

		return usersRepository.save(existing);
	}

	@Override
	public void deleteUser(Long id) {
		if (!usersRepository.existsById(id)) {
			throw new UserNotFoundException("Cannot delete. User not found with ID: " + id);
		}
		usersRepository.deleteById(id);
	}

}
