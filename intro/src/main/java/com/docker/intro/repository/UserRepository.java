package com.docker.intro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.docker.intro.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	
	}