package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户信息相关接口")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/getById")
  public Result getById(Integer id){
    return userService.getById(id);
  }

  @GetMapping("/sendEmailConfirm")
  public Result sendEmailConfirm(Integer userId, String emailAddress){
    return userService.sendEmailConfirm(userId, emailAddress);
  }

  @GetMapping("/emailConfirm")
  public Result emailConfirm(Integer userId, String emailAddress, String token){
    return userService.emailConfirm(userId, emailAddress, token);
  }

}
