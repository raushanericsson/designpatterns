package com.lenskart.manifest.service;

import java.util.List;
import java.util.Optional;

import com.lenskart.manifest.model.Users;

public interface UserService {
	
	public List<Users> getAllUsers();
	
	public Users updateUser(Users user);
	
	public Users saveUser(Users user);
	
	public Optional<Users> getUser(Integer id);

}
