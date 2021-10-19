package com.example.demo.model;


import lombok.Data;

@Data
public class SignUp {
	private String userName; 
	private String password;
	private String[] roles;
}
