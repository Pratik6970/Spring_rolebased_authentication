package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.User;

public interface UserService {
	
	public User postUser(User user);
	
	public List<User>getAllUsers();
	
	public ResponseEntity<User>getSingleUsers(Integer id);
	
	public User updateUsers(User user1,Integer id);
	
	public User deleteUsers(Integer id);

}
