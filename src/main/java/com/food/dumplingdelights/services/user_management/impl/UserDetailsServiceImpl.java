//package com.food.dumplingdelights.services.user_management.impl;
//
//
//import com.food.dumplingdelights.Entity.User;
//import com.food.dumplingdelights.repo.UserRepo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Objects;
//import java.util.Set;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
//    private final UserRepo userRepo;
//
//    @Autowired
//    public UserDetailsServiceImpl(UserRepo userRepo) {
//        this.userRepo= userRepo;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username){
//        User user = userRepo.findByUsername(username);
//
//        if (user != null) {
//            Set<GrantedAuthority> authorities = new HashSet<>();
//            if (Objects.equals(username, "admin")) {
//                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            }else {
//                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//            }
//            logger.debug(String.format("User with name: %s and password: %s created.", user.getUsername(), user.getPassword()));
//            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
//        }else{
//            throw new UsernameNotFoundException("User " + username + " not found!");
//        }
//    }
//
//
//}
