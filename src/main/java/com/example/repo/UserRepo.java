package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
	public User findByEmail(String email);
}
