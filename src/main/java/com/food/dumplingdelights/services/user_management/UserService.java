package com.food.dumplingdelights.services.user_management;

import com.food.dumplingdelights.Entity.User;
import com.food.dumplingdelights.pojo.UserPojo;

import java.io.IOException;
import java.util.List;

public interface UserService {
    UserPojo save(UserPojo userPojo) throws IOException;



    void login(String username, String password);
    User findById(long id);
    User fetchById(Integer id);

    List<Object> isUserPresent(UserPojo userPojo);

    List<User> fetchAll();
    void deleteById(Integer id);

}