package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Harry
 * @Date: 2019-10-09 19:56
 * @Version 1.0
 */

@RestController
@RequestMapping("/admin")
@Api(tags = "用户管理相关接口")
public class UserManagementController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserList")
    @ApiOperation("获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "用户列表页码",defaultValue = "1"),
            @ApiImplicitParam(name = "size",value = "每页条数",defaultValue = "10")
    })
    public Result getUserList(int pageNum,int size){
        return userService.getAllUser(pageNum,size);
    }


    @GetMapping("/delUser")
    @ApiOperation("删除指定用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",defaultValue = "1")
    })
    public Result delUser(int id){
        return userService.delUser(id);
    }


    @PostMapping("/updateUser")
    @ApiOperation("更新指定用户")
    public Result updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/selectUserByType")
    @ApiOperation("根据查询类型获取用户列表")
    public Result selectUserByType(String ttype,String content,int pageNum,int size){
        return userService.selectByType(ttype,content,pageNum,size);
    }

}