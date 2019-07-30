package com.example.demo3.service;

import com.example.demo3.entity.BuyFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuService {

    @Select("select * from buy_food")
    List<BuyFood> findAll();

    @Select("select * from buy_food where user_name = '朱宏'")
    List<BuyFood> findAllByZhuHong();

    @Select("select * from buy_food where user_name = '金彪'")
    List<BuyFood> findAllByJinBiao();

    @Select("select * from buy_food where user_name = '王浪'")
    List<BuyFood> findAllByWangLang();
}
