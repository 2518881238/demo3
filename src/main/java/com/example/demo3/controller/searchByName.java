package com.example.demo3.controller;

import com.example.demo3.entity.BuyFood;
import com.example.demo3.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class searchByName {
    @Resource
    private StuService ss;

    @PostMapping("/searchByName")
    public Map<String, Object> searchByName (@RequestParam(name = "name") String name) {
        System.out.println(name);
        Map<String, Object> jsonMap = new HashMap<>(30);
        jsonMap.put("params",ss.searchAllByName(name));
        return jsonMap;
    }
}
