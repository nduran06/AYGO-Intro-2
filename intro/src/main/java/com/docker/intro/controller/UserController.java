package com.docker.intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.intro.model.User;
import com.docker.intro.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/create")
    public String saveStudent(@RequestBody User user) {
		try {
			userService.createUser(user);
			
			return "{\"status\":\"success\"}";
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return "{\"status\":\"failed\"}";
		}
    }

}
