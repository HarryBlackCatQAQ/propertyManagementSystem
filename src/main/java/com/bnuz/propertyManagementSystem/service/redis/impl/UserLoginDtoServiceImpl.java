package com.bnuz.propertyManagementSystem.service.redis.impl;

import com.alibaba.fastjson.JSON;
import com.bnuz.propertyManagementSystem.dto.UserLoginDto;
import com.bnuz.propertyManagementSystem.service.redis.UserLoginDtoService;
import com.bnuz.propertyManagementSystem.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Util;

/**
 * @Author: Harry
 * @Date: 2019-10-22 18:46
 * @Version 1.0
 */
@Service("UserLoginDtoServiceImpl")
@Slf4j
public class UserLoginDtoServiceImpl implements UserLoginDtoService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void save(UserLoginDto userLoginDto,String ip) {
        String json = JSON.toJSONString(userLoginDto);
        redisUtil.set(UserLoginDtoRedisPre + ip,json,60);
    }
}