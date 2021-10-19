package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.Users;

@Service(value = "IUserService")

public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repository;

	// ADD NEW USER
	@Override
	public Users addNewUser(Users user) {
		return repository.save(user);
	}

	// USER SIGN IN
	@Override
	public Users signIn(Users user) {
		return null;
	}

	// USER SIGN OUT
	@Override
	public Users signOut(Users user) {
		return null;
	}

}