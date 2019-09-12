package com.example.demo3.controller;

import com.example.demo3.service.UserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class login {

    @Resource
    private UserService ss;

    @PostMapping("/login")
    public Map<String, Object> searchByNamePass(@RequestParam(name = "name") String name,
                                                @RequestParam(name = "pass") String pass,
                                                HttpServletRequest request,
                                                HttpServletResponse response) {
        System.out.println(name+pass);
        boolean b = ss.searchNamePass(name,pass);
        if (b == true && ("朱宏".equals(name) || "金彪".equals(name) || "王浪".equals(name))){
            HttpSession session = request.getSession();
            session.setAttribute("user",name);
        }
        Map<String, Object> jsonMap = new HashMap<>(2);
        jsonMap.put("params", b);
        return jsonMap;
    }
}
