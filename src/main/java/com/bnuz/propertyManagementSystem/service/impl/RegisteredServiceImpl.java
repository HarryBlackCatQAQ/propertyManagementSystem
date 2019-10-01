package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.ResultStatusCode;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.RegisteredService;
import com.bnuz.propertyManagementSystem.service.springsecurity.SpringSecurityPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Harry
 * @Date: 2019-10-01 14:43
 * @Version 1.0
 */

@Service("RegisteredServiceImpl")
public class RegisteredServiceImpl implements RegisteredService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SpringSecurityPasswordService springSecurityPasswordService;

    @Override
    public Result checkUserName(String username) {
        User user = userDao.selectByUserName(username);
        if(user == null){
            return new Result(true, ResultStatusCode.OK,"账号可以使用");
        }
        else{
            return new Result(false, ResultStatusCode.ERROR,"账号已存在!");
        }
    }

    @Override
    public Result registeredUser(User user) {
        synchronized (RegisteredServiceImpl.class){
            user.setPassword(springSecurityPasswordService.encodePassword(user.getPassword()));
            userDao.insert(user);
            return new Result(true,ResultStatusCode.OK,"注册成功!");
        }
    }
}