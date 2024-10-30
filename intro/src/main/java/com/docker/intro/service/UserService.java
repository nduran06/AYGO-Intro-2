package com.docker.intro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.intro.model.User;
import com.docker.intro.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void createUser(User user) throws JsonProcessingException {
		
		userRepo.insert(user);
		System.out.println("From service: "+ user.toString());
		
		
	}

}
