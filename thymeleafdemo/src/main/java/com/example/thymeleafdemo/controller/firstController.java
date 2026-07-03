package com.example.thymeleafdemo.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("api")
public class firstController {
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("pv/{name}")
    @ResponseBody
    public String pvEndpoint(@PathVariable String name){
        return "Hello "+name;
    }
    @RequestMapping("display")
    @ResponseBody
    public String rbEndpount(@RequestBody Map<String,String> mp){
        return "Hello "+mp.get("name");
    }
}
