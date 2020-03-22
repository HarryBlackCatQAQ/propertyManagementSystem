package com.bnuz.propertyManagementSystem;

import com.alibaba.fastjson.JSONObject;
import com.bnuz.propertyManagementSystem.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Harry
 * @Date: 2020-03-19 21:24
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisteredServiceTests {

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
    public void checkUserNameTest() throws Exception {
        String url = "/registered/checkUserName";
        String json = null;
        Map<String,String> params = new HashMap<>();

        params.put("username","789");

        Map<String,Object> res = testUtil.getResult(url,json,TestUtil.GET,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }

    @Test
    public void registeredTest() throws Exception {
        String url = "/registered/registeredUser";
        String json = null;
        Map<String,String> params = null;

        User user = new User();
        user.setUsername("789161561561515");
        user.setPassword("fc1200c7a7aa52109d762a9f005b149abef01479");
        user.setNickname("niuB");

        json = JSONObject.toJSONString(user);
        System.err.println(json);

        Map<String,Object> res = testUtil.getResult(url,json,TestUtil.POST,mockMvc);

        int status = (Integer)res.get("status");              //得到返回代码
        String content = (String)res.get("content");     //得到返回结果

        System.err.println(status);
        System.err.println(content);

        Assert.assertEquals(200,status);                        //断言，判断返回代码是否正确
    }

}