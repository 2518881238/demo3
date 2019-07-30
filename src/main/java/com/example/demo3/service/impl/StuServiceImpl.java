package com.example.demo3.service.impl;

import com.example.demo3.dao.StuDao;
import com.example.demo3.entity.BuyFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StuServiceImpl {

    @Autowired
    private StuDao stuDao;

//    @Override
//    public List<BuyFood> findAll(){
//        return stuDao.findAll();
//    }
}
