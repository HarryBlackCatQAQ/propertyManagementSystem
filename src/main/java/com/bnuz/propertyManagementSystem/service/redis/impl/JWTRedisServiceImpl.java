package com.bnuz.propertyManagementSystem.service.redis.impl;

import com.bnuz.propertyManagementSystem.service.redis.JWTRedisService;
import com.bnuz.propertyManagementSystem.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * token redis服务
 *
 * @Author: Harry
 * @Date: 2019-09-23 18:47
 * @Version 1.0
 */
@Service("JWTRedisServiceImpl")
public class JWTRedisServiceImpl implements JWTRedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object getToken(String userName) {
        return redisUtil.hget(TOKEN_HASH,userName);
    }

    @Override
    public boolean saveToken(String userName, String token) {
        if(isNull(userName) && isNull(token)){
            return false;
        }

        return redisUtil.hset(TOKEN_HASH,userName,token);
    }

    @Override
    public boolean delToken(String userName) {
        if(isNull(userName)){
            return false;
        }

        boolean flag = hasToken(userName);
        if(flag){
            redisUtil.hdel(TOKEN_HASH,userName);
        }

        return flag;
    }

    @Override
    public boolean hasToken(String userName) {
        if(isNull(userName)){
            return false;
        }

        return redisUtil.hHasKey(TOKEN_HASH,userName);
    }


    private boolean isNull(String s){
        return s == null;
    }
}