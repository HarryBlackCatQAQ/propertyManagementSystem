package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.RegisteredService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Harry
 * @Date: 2019-10-01 14:33
 * @Version 1.0
 */

@RestController
@RequestMapping("/registered")
@Api(tags = "用户注册相关接口")
public class RegisteredController {

    @Autowired
    private RegisteredService registeredService;

    @GetMapping("/checkUserName")
    @ApiOperation("检查用户是否存在接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名账号",defaultValue = "123")
    })
    public Result checkUserName(String username){
        return registeredService.checkUserName(username);
    }

    @PostMapping("/registeredUser")
    @ApiOperation("注册用户接口")
    public Result registered(@RequestBody User user){
        return registeredService.registeredUser(user);
    }
}