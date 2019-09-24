package com.bnuz.propertyManagementSystem;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.service.SpringSecurityPasswordService;
import com.bnuz.propertyManagementSystem.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyManagementSystemApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    SpringSecurityPasswordService springSecurityPasswordService;

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        String password = "123456";
        String newPassword = springSecurityPasswordService.encodePassword(password);


        System.err.println(newPassword);


        String key = "token";
        String a = springSecurityPasswordService.encodePassword(newPassword);
        redisUtil.sSet(key,a);
        redisUtil.sSetAndTime(key,20,newPassword,"3232");
//        long a = redisUtil.sSet(key,newPassword,"harry");
//        System.err.println(a);
//
//        boolean t1 = redisUtil.sHasKey(key,newPassword);
//        boolean t2 = redisUtil.sHasKey(key,"123");
//        boolean t3 = redisUtil.sHasKey(key,"harry6");
//        System.err.println(t1 + " " + t2 + " " + t3);

    }

}
