package com.lenskart.manifest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lenskart.manifest.model.Users;
import com.lenskart.manifest.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	
	@RequestMapping(value="/save" , method = RequestMethod.POST)
	public Users saveUser(@RequestBody Users user) {
		
		return userService.updateUser(user);
	}
	
	@RequestMapping(value ="/all/" , method = RequestMethod.GET)
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	public Optional<Users> getUser(Integer id) {
		return userService.getUser(id);
	}
	

	
	@Autowired
	private UserService userService;

}
