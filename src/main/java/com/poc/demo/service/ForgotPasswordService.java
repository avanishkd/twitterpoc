package com.poc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.demo.models.User;
import com.poc.demo.repositories.SignupRepository;

@Service
public class ForgotPasswordService {
	@Autowired
	SignupRepository signupRepository;

	public User updateUser(User user, String oldpassword) {

		User retreivedUser = signupRepository.findById(user.getId()).get();
		if (!retreivedUser.getPassword().equals(oldpassword)) {
			System.out.println("the old password does not match!");
			return null;

		}

		return signupRepository.save(retreivedUser);
	}
}
