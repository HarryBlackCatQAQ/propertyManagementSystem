package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.RegisteredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Harry
 * @Date: 2019-10-01 14:33
 * @Version 1.0
 */

@RestController
@RequestMapping("/registered")
public class RegisteredController {

    @Autowired
    private RegisteredService registeredService;

    @GetMapping("/checkUserName")
    public Result checkUserName(String username){
        return registeredService.checkUserName(username);
    }

    @PostMapping("/registeredUser")
    public Result registered(@RequestBody User user){
        return registeredService.registeredUser(user);
    }
}