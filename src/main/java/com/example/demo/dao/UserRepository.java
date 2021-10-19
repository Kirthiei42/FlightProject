package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	public Users findByUserName(String userName);

	public boolean existsByUserName(String userName);
}