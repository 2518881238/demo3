package com.example.demo3.dao;

import com.example.demo3.entity.BuyFood;
import com.example.demo3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StuDao extends JpaRepository<BuyFood, Long> {


}
