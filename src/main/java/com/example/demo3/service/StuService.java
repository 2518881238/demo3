package com.example.demo3.service;

import com.example.demo3.dao.StuDao;
import com.example.demo3.entity.BuyFood;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuService{

    @Resource
    private StuDao studao;

    public List<BuyFood> findAll(){
        return studao.findAllByIdd();
    }

    public boolean saveAll(BuyFood buyFood) {
        try{
            studao.save(buyFood);
            return true;
        } catch (Exception e){
            e.getMessage();
            return false;
        }
    }
    public List<BuyFood> searchAllByName(String name) {
        return studao.findAllByUserName(name);
    }

}
