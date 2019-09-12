package com.example.demo3.dao;

import com.example.demo3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    @Query("select q from User q where q.password  = :pass")
    List<User> findAllByNamePass(String pass);

}
