package com.food.dumplingdelights.repo;

import com.food.dumplingdelights.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


@Transactional


//yo repo le entity bata baneko table ma kam garcahu
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "select * from users where email=?1", nativeQuery = true)
    Optional<User> findByEmail(String email);



















}