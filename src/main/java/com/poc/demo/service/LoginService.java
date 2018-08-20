package com.poc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.poc.demo.models.User;
import com.poc.demo.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;

	public ResponseEntity<User> getUser(String id) {
		
		return loginRepository.findById(id).map(todo -> ResponseEntity.ok().body(todo))
				.orElse(ResponseEntity.notFound().build());
	}
}