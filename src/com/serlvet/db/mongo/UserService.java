package com.serlvet.db.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.serlvet.db.mongo.collection.UserInfo;
import com.serlvet.db.mongo.repository.UserRepository;

//@Configurable
public class UserService implements UserDetailsService {
//    @Autowired
//    UserRepository userRepository;
////    public UserService(UserRepository userRepository) {
////      this.userRepository = userRepository;
////    }
////    public void setUserRepository(UserRepository userRepository) {
////        this.userRepository = userRepository;
////    }
//    public UserService() {
//        System.out.println(userRepository);
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserInfo user = userRepository.findByUsername(username);
//        System.out.println(user);
//        return new User(user.getUsername(), user.getPassword(), null);
//    }

    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(), null);
    }

}
