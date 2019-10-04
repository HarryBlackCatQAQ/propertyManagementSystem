package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 测试Controller
 *
 * @Author: Harry
 * @Date: 2019-09-21 02:57
 * @Version 1.0
 */


@CrossOrigin
@RestController
@RequestMapping(value = "/test")
public class TestController {

//    @PreAuthorize("hasAnyRole('ROLE_0','ROLE_1','ROLE_2')")
    @GetMapping("/t1")
    public String t1(){
        return "t1";
    }

//    @PreAuthorize("hasAnyRole('ROLE_1','ROLE_2')")
    @GetMapping("/t2")
    public String t2(){
        return "t2";
    }

//    @PreAuthorize("hasAnyRole('ROLE_2')")
    @GetMapping("/t3")
    public String t3(){
        return "t3";
    }

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;


    @GetMapping("/page")
    public Object page(int pageNum,int size){
        return userService.getAllUser(pageNum,size).getData();
    }

    @GetMapping ("/login")
    public String tt1(String username,String password){
        System.out.println(username + " " + password);

        return "ok";
    }


    @GetMapping ("/login3")
    public String tt3(String username,String password){
        System.out.println(username + " " + password);

        return "ok3";
    }

    @PostMapping ("/login2")
    public String tt2(@RequestBody Map<String,String> map){
        System.out.println("2:" + map.get("username") + " " + map.get("password"));

        return "ok2";
    }

}