package com.example.service;

import com.example.binding.Login;
import com.example.binding.Register;

public interface UserService {

	
	public Boolean register(Register register);
	
	public String login(Login login);
}
