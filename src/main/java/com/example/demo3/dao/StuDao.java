package com.example.demo3.dao;

import com.example.demo3.entity.BuyFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StuDao extends JpaRepository<BuyFood, Long> {

    @Query("select p from BuyFood p")
    List<BuyFood> findAllByIdd();

    @Query("select p from BuyFood p where p.user_name = :userName")
    List<BuyFood> findAllByUserName(String userName);
}
