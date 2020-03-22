package com.bnuz.propertyManagementSystem;

import com.alibaba.fastjson.JSONObject;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Harry
 * @Date: 2020-03-19 22:33
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogFileTests {

    @Autowired
    private TestUtil testUtil;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;


    @Before
    public void init() throws Exception{

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    public void getLogFileListByFileNameTest() throws Exception{
        String url = "/admin/getLogFileListByFileName";
        String json = null;
        Map<String,String> params = new HashMap<>();

        params.put("preLevelName","root");

        Map<String,Object> res = testUtil.getResult(url,params,TestUtil.GET,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }
}