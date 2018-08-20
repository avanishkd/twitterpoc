package com.poc.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.poc.demo.models.User;

@Repository
public interface FollowRepository extends MongoRepository<User, String>{

}
