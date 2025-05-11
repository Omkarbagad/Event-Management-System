package com.capstoneproject.demo.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstoneproject.demo.backend.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
