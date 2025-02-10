package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.pojos.User;
import com.app.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	
	public UserServiceImpl() {
	System.out.println("UserService Impl called here");
	}

	@Override
	public User postUser(User user) {
		
		User user1 = userRepo.save(user);
		System.out.println(user1);
		return user1;
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User>users = userRepo.findAll();
		System.out.println(users);
		
		
		return users;
	}

	@Override
	public ResponseEntity<User> getSingleUsers(Integer id) {
	
		 User user2 = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found here"));
		 
		 if(user2!=null)
		 {
			 return ResponseEntity.ok(user2);
		 }
		 else
		 {
			 System.out.println("User not here");
			 return ResponseEntity.notFound().build();
		 }
		
	
	}

	@Override
	public User updateUsers(User user1, Integer id) {
		
		
		User user4 = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found here"));
		
		if(user4!=null)
		{
			user4.setName(user1.getName());
			
			user4.setCity(user1.getCity());
			
			user4.setMarks(user1.getMarks());
			
			userRepo.save(user4);
			
			System.out.println(user4);
			
			return user4;
		}
		else
		{
			throw new RuntimeException("NO user here");
		}
	}

	@Override
	public User deleteUsers(Integer id) {
	
		User user5 = userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found here"));
		
		if(user5!=null)
		{
			userRepo.delete(user5);
		}
		
		return user5;
	}
	

}
