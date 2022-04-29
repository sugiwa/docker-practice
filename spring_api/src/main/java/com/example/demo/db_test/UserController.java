package com.example.demo.db_test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		
		List<User> usersList = new ArrayList<User>();
		
		usersList = repository.findAll();
		
		return usersList;
	}
	
	@RequestMapping(value = "/test")
	public String getTest() {
		return "OK!";
	}
	


}
