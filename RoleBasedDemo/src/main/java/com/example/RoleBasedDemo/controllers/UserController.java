package com.example.RoleBasedDemo.controllers;

import com.example.RoleBasedDemo.entities.User;
import com.example.RoleBasedDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String getLoginPage(){
        return "login";
    }
    @RequestMapping("/user/login")
    public String getUser(@RequestParam("email") String email,@RequestParam("password") String password) {
        String user=userService.getUser(email,password);
        if (user.equalsIgnoreCase("admin")) {
            return "admin";
        } else {
            return "user";
        }
    }
}
