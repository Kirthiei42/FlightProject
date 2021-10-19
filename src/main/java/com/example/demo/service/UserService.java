package com.example.demo.service;

import com.example.demo.model.Users;

public interface UserService {
	public abstract Users addNewUser(Users user);
	public abstract Users signIn(Users user);
	public abstract Users signOut(Users user);

}
