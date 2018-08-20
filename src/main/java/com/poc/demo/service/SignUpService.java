package com.poc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poc.demo.models.User;
import com.poc.demo.repositories.LoginRepository;
import com.poc.demo.repositories.SignupRepository;

@Service
public class SignUpService {

	@Autowired
	SignupRepository signupRepository;


	public User saveUser(User user) {
		
		if(signupRepository.findById(user.getId()).isPresent())
			return null;
		

		return signupRepository.save(user);
	}
}
