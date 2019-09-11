package com.example.demo3.controller;

import com.example.demo3.entity.BuyFood;
import com.example.demo3.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
public class turnBack {
    @Resource
    private StuService ss;

    @PostMapping("add")
    @ResponseBody
    public Map turnHome(@RequestParam(name = "name") String name,
                        @RequestParam(name = "price") String price,
                        @RequestParam(name = "desc") String desc, BuyFood buyFood){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        float price1 = Float.parseFloat(price);
        buyFood.setUser_name(name);
        buyFood.setPrice(price1);
        buyFood.setRe_mark(desc);
        buyFood.setDate(df.format(new Date()));
        System.out.println(buyFood.toString());
        boolean result = ss.saveAll(buyFood);
        Map re = new HashMap(16);
        if (result == true){
            re.put("msg","后台新增数据成功");
        }else {
            re.put("msg","后台新增数据失败");
        }
        return re;
    }
}
