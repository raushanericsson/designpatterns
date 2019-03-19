package com.lenskart.manifest.serviceimpl;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lenskart.manifest.model.MongoUsers;
import com.lenskart.manifest.model.Users;
import com.lenskart.manifest.repository.MongoUserRepository;
import com.lenskart.manifest.repository.UserRepository;
import com.lenskart.manifest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	
	
	// For unchecked Exception specific rollbackFor is not needed 
	// In Case of checked Exception specific roolbackFor need to be included
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Users updateUser(Users user){
		Users userR = userRepository.save(user);

		MongoUsers mu = new MongoUsers(user.getId(),user.getFirstName(),user.getLastName(),user.getCountry(),user.getCompany());
		
		mongoRepository.save(mu);
		
		System.out.println(1/0);
		return userR;
		
	}

	@Override
	public Optional<Users> getUser(Integer id) {
		return userRepository.findById(id);
	}
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoUserRepository mongoRepository;



	@Override
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

}
