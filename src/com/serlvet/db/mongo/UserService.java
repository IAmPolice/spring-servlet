package com.serlvet.db.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.serlvet.db.mongo.collection.UserInfo;
import com.serlvet.db.mongo.repository.UserRepository;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    public UserService (UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(), null);
    }

}
