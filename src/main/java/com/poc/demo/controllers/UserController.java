package com.poc.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.demo.models.User;
import com.poc.demo.service.FollowService;
import com.poc.demo.service.ForgotPasswordService;
import com.poc.demo.service.LoginService;
import com.poc.demo.service.SignUpService;

@RestController
@RequestMapping("/service")
@CrossOrigin("*")
public class UserController {
	@Autowired
	LoginService loginService;

	@Autowired
	SignUpService signupService;
	
	@Autowired
	FollowService followService;
	
	@Autowired
	ForgotPasswordService forgotPasswordService;

	@GetMapping(value = "/login/{id}")
	public String getTodoById(@PathVariable("id") String id) {
		User user= loginService.getUser(id).getBody();
		if(user==null) {
			return "User does not exist! :(";
		}
		return user.toString();
		

	}

	@PostMapping("/signup")
	public String createUser(@Valid @RequestBody User user) {

		User userReg= signupService.saveUser(user);
		
		if (userReg==null) {
			return "User already exists!";
		}
		
		return "user registered successfully!";
	}
	
	@PutMapping(value = "/follow/{id}")
	public User followUsers(@PathVariable("id") String id, @Valid @RequestBody User user) {
		
		System.out.println(id);
		return followService.follow(id, user);
	}
	
	@PutMapping(value = "/forgotpwd/{oldpwd}")
	public User changePassword(@PathVariable("oldpwd") String oldpwd, @Valid @RequestBody User user) {
		
		System.out.println(oldpwd);
		return forgotPasswordService.updateUser(user, oldpwd);
	}


}
