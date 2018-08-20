package com.poc.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.demo.models.User;
import com.poc.demo.repositories.FollowRepository;

@Service
public class FollowService {

	@Autowired
	FollowRepository followRepository;

	public User follow(String id, User user) {

		if (!followRepository.findById(id).isPresent()) {
			System.out.println("user to follow does not exist");
			return null;
		}

		if (!followRepository.findById(user.getId()).isPresent()) {
			System.out.println("the requested user does not exist!");
			return null;
		}

		User userRetrieved = followRepository.findById(user.getId()).get();
		if (userRetrieved.getUsersIfollow() == null) {
			ArrayList<String> al = new ArrayList<String>();
			al.add(id);
			userRetrieved.setUsersIfollow(al);

		}else {
			userRetrieved.getUsersIfollow().add(id);
		}
		
		followRepository.save(userRetrieved);
		
		return userRetrieved;

	}
}