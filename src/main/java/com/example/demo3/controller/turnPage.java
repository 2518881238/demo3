package com.example.demo3.controller;

import com.example.demo3.entity.BuyFood;
import com.example.demo3.service.StuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class turnPage {

    @Resource
    private StuService ss;

    @RequestMapping("/zh")
    public Map<String, Object> findAlll(){
        Map<String, Object> jsonMap = new HashMap<>(20);
        List<BuyFood> infoList = ss.findAll();
        jsonMap.put("params",infoList);
        System.out.println(jsonMap.toString());
        return jsonMap;
    }
    @RequestMapping("/zh1")
    public Map<String, Object> findA(){
        Map<String, Object> jsonMap = new HashMap<>(20);
        List<BuyFood> infoList = ss.findAll();
        float zhu = 0;
        float zhu1 = 0;
        float jin = 0;
        float jin1 = 0;
        float wang = 0;
        float wang1 = 0;
       for (int i=0; i<infoList.size(); i++){
           if ("朱宏".equals(infoList.get(i).getUser_name())){
               zhu = zhu + infoList.get(i).getPrice();
           }
           if ("金彪".equals(infoList.get(i).getUser_name())){
               jin = jin + infoList.get(i).getPrice();
           }
           if ("王浪".equals(infoList.get(i).getUser_name())){
               wang = wang + infoList.get(i).getPrice();
           }

           float a = (zhu + jin + wang)/3;
           zhu1 = zhu - a;
           jin1 = jin - a;
           wang1 = wang - a;
       }

        jsonMap.put("zhu",zhu);
        jsonMap.put("jin",jin);
        jsonMap.put("wang",wang);
        jsonMap.put("zhu1",zhu1);
        jsonMap.put("jin1",jin1);
        jsonMap.put("wang1",wang1);

        System.out.println(jsonMap.toString());
        return jsonMap;
    }
}
