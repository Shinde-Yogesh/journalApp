package com.practice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
	User findByUserName(String username);

	void deleteByUserName(String userName);
}
