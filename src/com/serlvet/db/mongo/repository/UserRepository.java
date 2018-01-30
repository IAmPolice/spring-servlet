package com.serlvet.db.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.serlvet.db.mongo.schema.UserInfo;

@Repository
public interface UserRepository extends MongoRepository<UserInfo, String> {
    @Query("{username: ?0}")
    UserInfo findByUsername(String username);

    List<UserInfo> findByUsernameOrRole(String username, String role);

    List<UserInfo> findByUsernameAndRole(String username, String role);

    List<UserInfo> findDistinctUsersByUsernameAndRole(String username, String role);

    // 忽略參數大小寫
    List<UserInfo> findByRoleIgnoreCase(String role);

    List<UserInfo> findByRole(String role);
}
