package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Harry
 * @Date: 2019-09-20 15:54
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/admin")
public class SystemAdministratorController {

    @PostMapping(value = "/addUser")
    public Result addUser(){
        return new Result();
    }


    @PostMapping(value = "/updateUser")
    public  Result updateUser(){
        return new Result();
    }

}