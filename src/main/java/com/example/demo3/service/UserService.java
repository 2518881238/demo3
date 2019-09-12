package com.example.demo3.service;

import com.example.demo3.dao.UserDao;
import com.example.demo3.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public boolean searchNamePass(String name,String pass){
        boolean b = false;
        List<User> a = userDao.findAllByNamePass(pass);
        for (int i=0; i<a.size(); i++){
            if (a != null && !a.isEmpty() && name.equals(a.get(i).getUser_name())){
                b=true;
            }
        }
        return b;
    }
}
