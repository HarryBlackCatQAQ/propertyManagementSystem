package com.bnuz.propertyManagementSystem;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.model.UserExample;
import com.bnuz.propertyManagementSystem.util.SHA1Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyManagementSystemApplicationTests {


    @Autowired
    SHA1Util sha1Util;

    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads() {
        System.err.println(sha1Util.encodePassword("6adfb183a4a2c94a2f92dab5ade762a47889a5a1"));
        User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        User user1 = userDao.selectByUser(user);

        System.out.println(user1);
        System.out.println(user);


    }

}
