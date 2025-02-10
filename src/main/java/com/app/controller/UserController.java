package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("User Controller called here");
	}
	
	@PostMapping("/post")
	public ResponseEntity<User>postUsers(@RequestBody User user)
	{
		User user1 = userService.postUser(user);
		System.out.println(user1);
		
		return new ResponseEntity<>(user1,HttpStatus.OK);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<User>>getAllUsers()
	{
		List<User>users = userService.getAllUsers();
		
		System.out.println(users);
		
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/single/{id}")
	public ResponseEntity<User>getSingleUser(@PathVariable Integer id)
	{
		ResponseEntity<User>user4=userService.getSingleUsers(id);
		System.out.println(user4);
		return user4;
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User>updateUser(@RequestBody User user6,@PathVariable Integer id)
	{
		User user7 = userService.updateUsers(user6, id);
		
		System.out.println("User7 = "+user7);
		
		return new ResponseEntity<>(user7,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User>deleteUser(@PathVariable Integer id)
	{
		User user8 = userService.deleteUsers(id);
		
		System.out.println("User7 = "+user8);
		
		return new ResponseEntity<>(user8,HttpStatus.OK);
	}

}
