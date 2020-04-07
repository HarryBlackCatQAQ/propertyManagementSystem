package com.bnuz.propertyManagementSystem;

import com.bnuz.propertyManagementSystem.service.DataBaseBackupService;
import com.bnuz.propertyManagementSystem.service.impl.DataBaseBackupServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Harry
 * @Date: 2020-04-06 16:41
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBaseBackupServiceTests {

    @Autowired
    DataBaseBackupService dataBaseBackupService;

    @Test
    public void test1() throws InterruptedException {
        System.err.println(dataBaseBackupService.saveDbFile());
    }
}