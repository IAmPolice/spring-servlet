package com.serlvet.db.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.serlvet.db.mongo.collection.UserInfo;

public interface UserRepository extends MongoRepository<UserInfo, String> {
    @Query("{username: ?0}")
    UserInfo findByUsername(String username);
}
