package com.docker.intro.model;

import java.util.Date;

import org.mongodb.morphia.annotations.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.docker.intro.util.Parser;
import com.fasterxml.jackson.core.JsonProcessingException;

@Document(collection = "user")
public class User {


	@Id
    private String id;
	private String name;
	private String email;
	private String password;
	private String timestamp;

	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.timestamp = Parser.defaultFormatDateTime(new Date());
	}

	// getters and setters
	public String getName() {

		return this.name;
	}
	
	public void setName(String name) {

		this.name = name;
	}
	
	public String getEmail() {

		return this.email;
	}
	
	public void setEmail(String email) {

		this.email = email;
	}
	
	public String getPassword() {

		return this.password;
	}
	
	public void setPassword(String password) {

		this.password = password;
	}
	
	public String getTimestamp() {

		return this.timestamp;
	}
	
	public void setTimestamp(String timestamp) {

		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		try {
			return Parser.objectToJson(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}