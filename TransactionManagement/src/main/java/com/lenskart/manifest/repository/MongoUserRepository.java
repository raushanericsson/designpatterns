package com.lenskart.manifest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lenskart.manifest.model.MongoUsers;

public interface MongoUserRepository extends MongoRepository<MongoUsers,String> {

}
