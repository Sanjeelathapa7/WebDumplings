package com.food.dumplingdelights.services.user_management.impl;


import com.food.dumplingdelights.config.PasswordEncoderUtil;
import com.food.dumplingdelights.Entity.User;
import com.food.dumplingdelights.pojo.UserPojo;
import com.food.dumplingdelights.repo.UserRepo;
import com.food.dumplingdelights.services.user_management.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;



    @Override
    public UserPojo save(UserPojo userPojo) throws IOException {
        User user;
        if (userPojo.getId() != null) {
            user = userRepo.findById(userPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
        } else {
            user = new User();
        }
        user.setEmail(userPojo.getEmail());
        user.setFullName(userPojo.getFullname());
//        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return new UserPojo(user);
    }

    @Override
    public List<Object> isUserPresent(UserPojo userPojo) {
        return null;
    }


    public List<User> fetchAll() {
        return userRepo.findAll();
    }
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    public void deleteById(Integer id){
        userRepo.deleteById(id);
    }

    @Override
    public void login(String username, String password) {
    }

    @Override
    public User findById(long id) {
        return null;
    }

}