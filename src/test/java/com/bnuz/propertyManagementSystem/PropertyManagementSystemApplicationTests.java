package com.bnuz.propertyManagementSystem;

import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.service.ComplaintAndSuggestionSheetService;
import com.bnuz.propertyManagementSystem.service.HouseFeeRecordService;
import com.bnuz.propertyManagementSystem.service.springsecurity.SpringSecurityPasswordService;
import com.bnuz.propertyManagementSystem.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
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

    @Autowired
    ComplaintAndSuggestionSheetService complaintAndSuggestionSheetService;


    @Autowired
    HouseFeeRecordService houseFeeRecordService;
    @Test
    public void contextLoads() {
        System.err.println(complaintAndSuggestionSheetService.queryOwnerComplaintAndSuggestionSheetByType("正在处理",1,10));
        System.err.println();
        System.err.println(complaintAndSuggestionSheetService.queryOwnerComplaintAndSuggestionSheetByType("待处理",1,10));
        System.err.println();
        System.err.println(complaintAndSuggestionSheetService.queryOwnerComplaintAndSuggestionSheetByType("已完成",1,10));
        System.err.println();
        System.err.println(complaintAndSuggestionSheetService.queryOwnerComplaintAndSuggestionSheetByType("all",1,10));
    }

}
