package com.lenskart.manifest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.lenskart.manifest.model.Users;

public interface UserRepository extends CrudRepository<Users,Integer>{
	
	List<Users> findAll();
	
	

}
