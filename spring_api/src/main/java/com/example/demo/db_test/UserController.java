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
@CrossOrigin(origins = {"http://localhost:8081/"})
public class UserController {

	@Autowired
	UserRepository repository;
	
	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		List<User> usersList = new ArrayList<User>();
		usersList = repository.findAll();
		
		return usersList;
	}

	@RequestMapping(value = "/api/users/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable("userId") int userId) {
		User user = repository.getById(userId);
		
		return user;
	}
	
	@RequestMapping(value = "/api/users/", method = RequestMethod.POST)
	public void createUser(@RequestBody UserForm form) {		
		User user = new User();
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		repository.save(user);
	}
	
	@RequestMapping(value = "/api/users/{userId}", method = RequestMethod.POST)
	public void updateUser(@RequestBody UserForm form, @PathVariable int userId) {		
		User user = repository.getById(userId);
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		repository.save(user);
	}

	@RequestMapping(value = "/api/users/{userId}/delete", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable int userId) {
		User user = repository.getById(userId);
		repository.delete(user);
	}

	// TEST
	@RequestMapping(value = "/api/users/test")
	public String getTest() {
		return "OK!";
	}
	@RequestMapping(value = "/api/users/valTest/{val}")
	public int getValTest(@PathVariable int val) {
		return val;
	}
	@RequestMapping(value = "/api/users/testUser", method = RequestMethod.GET)
	public List<User> getTestUsers() {
		List<User> usersList = new ArrayList<User>();
		usersList.add(new User());
		return usersList;
	}
	


}
