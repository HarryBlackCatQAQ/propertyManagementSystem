package com.bnuz.propertyManagementSystem.service.redis.impl;

import com.bnuz.propertyManagementSystem.service.redis.LoginFailureTimesService;
import com.bnuz.propertyManagementSystem.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Harry
 * @Date: 2019-10-22 12:58
 * @Version 1.0
 */

@Service("LoginFailureTimesServiceImpl")
public class LoginFailureTimesServiceImpl implements LoginFailureTimesService {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 设置登录失败次数超过5次以后要使用验证码进行登录
     * @param ip
     * @return
     */
    @Override
    public boolean checkIpLoginTimes(String ip) {

        //第一次登录失败会抓取Null exception
        try{
            int times = (int)redisUtil.get(ip);

            long expire = redisUtil.getExpire(ip);

            if(times >= 4){
                redisUtil.set(ip,times + 1,expire);
                return true;
            }

            redisUtil.set(ip,times + 1,expire);
        }
        catch (NullPointerException e){
            //设置15分钟内需要验证码
            redisUtil.set(ip,1,60 * 15);
        }


        return false;
    }

    @Override
    public void delLoginFailTimes(String ip) {
        redisUtil.del(ip);
    }
}