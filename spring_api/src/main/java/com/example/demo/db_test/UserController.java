package com.example.demo.db_test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	UserRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUsers() {
		
		List<User> usersList = new ArrayList<User>();
		
		usersList = repository.findAll();
		
		return usersList;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable int userId) {
		User user = new User();
		
		user = repository.getById(userId);
		
		return user;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createUser(@RequestBody UserForm form) {
		System.out.println(form);
		
		User user = new User();
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		repository.save(user);
		
		
		
	}
	
	@RequestMapping(value = "/test")
	public String getTest() {
		return "OK!";
	}
	
	@RequestMapping(value = "/testUser", method = RequestMethod.GET)
	public List<User> getTestUsers() {
		
		List<User> usersList = new ArrayList<User>();
		
		usersList.add(new User());
		
		return usersList;
	}
	


}
