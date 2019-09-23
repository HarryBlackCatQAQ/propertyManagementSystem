package com.bnuz.propertyManagementSystem;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.service.SpringSecurityService;
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
    SpringSecurityService springSecurityService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("123");
        String password = "123456";
        String newPassword = springSecurityService.encodePassword(password);


        System.err.println(newPassword);

        user.setPassword(newPassword);

        user.setNickname("ttt");
        user.setRole(0);

//        userDao.insert(user);

        User user1 = userDao.selectByPrimaryKey(2);
        System.err.println(user1);

        boolean flag1 = springSecurityService.matchesPassword(password,user1.getPassword());
        boolean flag2 = springSecurityService.matchesPassword("123",user1.getPassword());
        System.err.println(flag1 + " " + flag2);

    }

}
