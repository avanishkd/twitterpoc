package com.poc.demo.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	@Size(max = 100)
	private String id;

	@NotBlank
	@Indexed(unique = true)
	private String name;

	@NotBlank
	@Indexed(unique = true)
	private String password;

	@Indexed
	private ArrayList<String> usersFollowing;

	@Indexed
	private ArrayList<String> usersIfollow;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getUsersFollowing() {
		return usersFollowing;
	}

	public void setUsersFollowing(ArrayList<String> usersFollowing) {
		this.usersFollowing = usersFollowing;
	}

	public ArrayList<String> getUsersIfollow() {
		return usersIfollow;
	}

	public void setUsersIfollow(ArrayList<String> usersIfollow) {
		if (this.usersIfollow == null) {
			this.usersIfollow = usersIfollow;
		} else
			this.usersIfollow.addAll(usersIfollow);
	}

	@Override
	public String toString() {
		return String.format("User[id=%s, title='%s', completed='%s']", id, name, password);
	}

}
