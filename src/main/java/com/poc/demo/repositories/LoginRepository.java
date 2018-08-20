package com.poc.demo.repositories;

import com.poc.demo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends MongoRepository<User, String>{

}
