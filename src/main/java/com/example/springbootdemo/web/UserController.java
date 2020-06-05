package com.example.springbootdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserController {

    {
        System.out.println("context__________");
    }

    @Autowired
    private Environment env;

    @GetMapping("/user")
    public String getUser(HttpServletRequest request, HttpServletResponse response) {
        String s = env.getActiveProfiles()[0];
        return s;
    }
}
